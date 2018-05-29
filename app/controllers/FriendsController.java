package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;
import io.swagger.annotations.*;
import models.Friend;
import models.FriendRequest;
import models.Friends;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repository.IFriendsRepository;
import repository.IRequestRepository;
import util.Util;

import java.util.List;

@Api(value = "/", description = "Operations with Friends")
public class FriendsController  extends Controller {
    @Inject
    private IFriendsRepository friendsRepo;
    private FriendRequest friendRequest;

    @ApiOperation(
            nickname = "createUser",
            value = "Create user record in Friend collection when creating a new user",
            notes = "Create Friend record",
            httpMethod = "POST",
            response = Friend.class
    )
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "Friend",
                            required = true,
                            paramType = "body",
                            value = "Friend"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    public Result save(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        friendsRepo.save(Json.fromJson(json, Friend.class));
        return ok("insert user success");
    }

    @ApiOperation(value = "get All Friends",
            notes = "Returns List of all Users",
            response = Friend.class,
            httpMethod = "GET")
    public Result getAll(){
        List<Friend> friends =  friendsRepo.findAll();
        return ok(Json.toJson(friends));
    }

    @ApiOperation(value = "Store a new friend",
            notes = "Add a friend for a user",
            response = Friends.class,
            httpMethod = "GET")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "Friends",
                            required = true,
                            paramType = "body",
                            value = "Friends"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    public Result append(String userId){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }

        Gson gson = new Gson();

        Friends friends = gson.fromJson(json.toString(), Friends.class);
        friendsRepo.append(userId , friends);
        return ok(Json.toJson("Update friend successfully"));
    }

    @ApiOperation(value = "Delete a friend",
            notes = "Delete a friend",
            response = Friend.class,
            httpMethod = "DELETE")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "Friend",
                            required = true,
                            paramType = "body",
                            value = "Friend"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    public Result deleteFriend(){
        Friends friend = friendsRepo.deleteFriend();
        return ok(Json.toJson(friend));
    }

//    public Result findByReq(String from_uid, String to_uid){
////        JsonNode json = request().body().asJson();
//        if(from_uid == null || to_uid == null){
//            return badRequest(Util.createRespone("Expecting Json data", false));
//        }
//        FriendRequest found_request = friendsRepo.findByReq(from_uid, to_uid);
//
//        Gson gson = new Gson();
//        return ok(gson.toJson(found_request));
//    }


    @ApiOperation(value = "Check whether a friend",
            notes = "Check whether a friend",
            response = boolean.class,
            httpMethod = "DELETE")
    public Result isFriend(String current_id, String userId){
//        JsonNode json = request().body().asJson();
//        if(json == null){
//            return badRequest(Util.createRespone("Expecting Json data", false));
//        }

        Gson gson = new Gson();

        //Friends friends = gson.fromJson(json.toString(), Friends.class);
        boolean status = friendsRepo.isFriend(current_id, userId);
        return ok(Json.toJson(status));
    }

    @ApiOperation(value = "Send push notifications for all friends of a particular uid",
            notes = "Should pass uid of a user",
            response = boolean.class,
            httpMethod = "DELETE")
    public Result sendNotify(String uuid,String lat, String lng){
        friendsRepo.sendNotify(uuid);
        return ok();
    }
}

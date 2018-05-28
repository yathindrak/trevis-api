package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;
import io.swagger.annotations.*;
import models.Friend;
import models.FriendRequest;
import models.Friends;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repository.IRequestRepository;
import util.Util;

import java.util.List;

@Api(value = "/", description = "Operations with Friend Requests")
public class FriendReqController  extends Controller {
    @Inject
    private IRequestRepository request;
    private Friend friend;

    @ApiOperation(
            nickname = "createRequest",
            value = "Create FriendRequest",
            notes = "Create FriendRequest record",
            httpMethod = "POST",
            response = FriendRequest.class
    )
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "FriendRequest",
                            required = true,
                            paramType = "body",
                            value = "FriendRequest"
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
        request.save(Json.fromJson(json, FriendRequest.class));
        return ok("insert user success");
    }

    @ApiOperation(value = "Get All Friend Requests",
            notes = "Returns List of all Friend Requests",
            response = FriendRequest.class,
            httpMethod = "GET")
    public Result getAll(){
        List<FriendRequest> requests =  request.findAll();
        return ok(Json.toJson(requests));
    }

    @ApiOperation(value = "Get a friend request",
            notes = "Returns a friend request by sender and receiver's UIDs",
            response = FriendRequest.class,
            httpMethod = "GET")
    public Result findByReq(String from_uid, String to_uid){
//        JsonNode json = request().body().asJson();
        if(from_uid == null || to_uid == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        FriendRequest found_request = request.findByReq(from_uid, to_uid);

        Gson gson = new Gson();
        return ok(Json.toJson(found_request));
    }

    @ApiOperation(value = "Delete a friend request",
            notes = "Delete a friend request",
            response = boolean.class,
            httpMethod = "DELETE")
    public Result deleteReq(String from, String to){
        JsonNode json = request().body().asJson();
        Gson gson = new Gson();
//        if(json == null){
//            return badRequest(Util.createRespone("Expecting Json data", false));
//        }
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setFrom(from);
        friendRequest.setTo(to);

        boolean status = request.deleteReq(friendRequest);


        return ok(Json.toJson(status));
    }




//    public Result append(){
//        JsonNode json = request().body().asJson();
//        if(json == null){
//            return badRequest(Util.createRespone("Expecting Json data", false));
//        }
//
//        Gson gson = new Gson();
//
//        Friends address = gson.fromJson(json.toString(), Friends.class);
//
//
//        http://localhost:9000/update/Yathindra
//        user.append(address);
//        return ok(Json.toJson("Update user successfully"));
//    }
}

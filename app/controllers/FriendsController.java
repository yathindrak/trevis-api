package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;
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

public class FriendsController  extends Controller {
    @Inject
    private IFriendsRepository friendsRepo;
    private FriendRequest friendRequest;

    public Result save(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        friendsRepo.save(Json.fromJson(json, Friend.class));
        return ok("insert user success");
    }

    public Result getAll(){
        List<Friend> friends =  friendsRepo.findAll();
        return ok(Json.toJson(friends));
    }

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
}

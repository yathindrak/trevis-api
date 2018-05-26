package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.inject.Inject;
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

public class FriendReqController  extends Controller {
    @Inject
    private IRequestRepository request;
    private Friend friend;

    public Result save(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        request.save(Json.fromJson(json, FriendRequest.class));
        return ok("insert user success");
    }

    public Result getAll(){
        List<FriendRequest> requests =  request.findAll();
        return ok(Json.toJson(requests));
    }

    public Result findByReq(String from_uid, String to_uid){
//        JsonNode json = request().body().asJson();
        if(from_uid == null || to_uid == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        FriendRequest found_request = request.findByReq(from_uid, to_uid);

        Gson gson = new Gson();
        return ok(gson.toJson(found_request));
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

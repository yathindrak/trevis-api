package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import io.swagger.annotations.*;
import models.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import repository.IUserRepository;
import util.Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

@Api(value = "/", description = "Operations with User")
public class UserController extends Controller {
    @Inject
    private IUserRepository user;
    private User usr;

    @ApiOperation(
            nickname = "createUser",
            value = "Create User",
            notes = "Create User record",
            httpMethod = "POST",
            response = User.class
    )
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "User",
                            required = true,
                            paramType = "body",
                            value = "User"
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
        user.save(Json.fromJson(json, User.class));
        return ok("insert user success");
    }

    @ApiOperation(value = "Get All Users",
            notes = "Returns List of all Users",
            response = User.class,
            httpMethod = "GET")
    public Result getAll(){
        List<User> users =  user.findAll();
        return ok(Json.toJson(users));
    }


    @ApiOperation(value = "Get a user",
            notes = "Returns a User by UID",
            response = User.class,
            httpMethod = "GET")
    public Result findById(String uid){
        JsonNode json = request().body().asJson();
        if(uid == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        User found_user = user.findById(uid);

        Gson gson = new Gson();
        return ok(gson.toJson(found_user));
    }


    public Result query()
    {
        return ok(Json.toJson(user.findAll()));
    }

    @ApiOperation(value = "Update user by uid",
            notes = "Returns a user",
            response = User.class,
            httpMethod = "GET")
    public Result update(String id){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.update(id, Json.fromJson(json, User.class));
        return ok(Json.toJson("Update user successfully"));
    }


    public Result append(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }

        Gson gson = new Gson();

        Friends address = gson.fromJson(json.toString(), Friends.class);


        //http://localhost:9000/update/Yathindra
        user.append(address);
        return ok(Json.toJson("Update user successfully"));
    }

//    public Result appendFrndReq(){
//        JsonNode json = request().body().asJson();
//        if(json == null){
//            return badRequest(Util.createRespone("Expecting Json data", false));
//        }
//
//        Gson gson = new Gson();
//
//        FriendRequest request = gson.fromJson(json.toString(), FriendRequest.class);
//
//
//        http://localhost:9000/update/Yathindra
//        user.appendFriendRequest(request);
//        return ok(Json.toJson("Update user successfully"));
//    }

    @ApiOperation(value = "Update user by name",
            response = User.class,
            httpMethod = "PUT")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "User",
                            required = true,
                            paramType = "body",
                            value = "User"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    public Result updateByName(String name){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.updateByName(name, Json.fromJson(json, User.class));
        return ok(Json.toJson("Update user successfully"));
    }

    @ApiOperation(value = "Update user by uid",
            response = User.class,
            httpMethod = "PUT")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(
                            name = "body",
                            dataType = "User",
                            required = true,
                            paramType = "body",
                            value = "User"
                    )
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 500, message = "Bad Request")
            }
    )
    public Result updateByUID(String uid){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.updateByUID(uid, Json.fromJson(json, User.class));
        return ok(Json.toJson("Update user successfully"));
    }

    public Result sendNotification(String device_token){
        System.out.println("Welcome to Developine");


        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(
                "https://fcm.googleapis.com/fcm/send");

        NotificationRequestModel notificationRequestModel = new NotificationRequestModel();
        NotificationData notificationData = new NotificationData();

        notificationData.setDetail("this is firebase push notification from java client (server)");
        notificationData.setTitle("Hello Firebase Push Notification");
        notificationRequestModel.setData(notificationData);
        notificationRequestModel.setTo(device_token);


        Gson gson = new Gson();
        Type type = new TypeToken<NotificationRequestModel>() {
        }.getType();

        String json = gson.toJson(notificationRequestModel, type);

        StringEntity input = null;
        try {
            input = new StringEntity(json);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        input.setContentType("application/json");
        postRequest.addHeader("Authorization", "key=KEY_SHOULD_GOES_HERE");
        postRequest.setEntity(input);


        System.out.println("request:" + json);


        HttpResponse response = null;
        try {
            response = httpClient.execute(postRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        } else if (response.getStatusLine().getStatusCode() == 200) {

            try {
                System.out.println("response:" + EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return ok();
    }

    @ApiOperation(value = "Send Email",
            response = User.class,
            httpMethod = "POST")
    public Result sendMail(String email_to){
        //new MailerService().sendEmail();

        Email email = EmailBuilder.startingBlank()
                .from("Michel Baker", "m.baker@mbakery.com")
                .to("mom", email_to)
//                .to("dad", "StevenOakly1963@hotmail.com")
                .withSubject("My Bakery is finally open!")
                .withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!")
                .buildEmail();

        //For now added a fake email and password
        MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "thilisadunik@gmail.com", "thilisadunik123")
                .buildMailer()
                .sendMail(email);


        return ok();
    }


    @ApiOperation(value = "Update the user location",
            response = User.class,
            httpMethod = "POST")
    public Result updateLocation(String uid, double latitude, double longitude){

        user.updateLocation(uid, latitude, longitude);
        return ok();
    }
}

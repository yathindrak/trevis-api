package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import models.Address;
import models.NotificationData;
import models.NotificationRequestModel;
import models.User;
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

public class UserController extends Controller {
    @Inject
    private IUserRepository user;
    private User usr;

    public Result save(){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.save(Json.fromJson(json, User.class));
        return ok("insert user success");
    }

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

        Address address = gson.fromJson(json.toString(), Address.class);


        http://localhost:9000/update/Yathindra
        user.append(address);
        return ok(Json.toJson("Update user successfully"));
    }

    public Result updateByName(String name){
        JsonNode json = request().body().asJson();
        if(json == null){
            return badRequest(Util.createRespone("Expecting Json data", false));
        }
        user.updateByName(name, Json.fromJson(json, User.class));
        return ok(Json.toJson("Update user successfully"));
    }

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
        postRequest.addHeader("Authorization", "key=AAAA2U0NWhk:APA91bEIyK83CJMgM4NkA5JlO42laoT6VRAmVp4kv-DVdQB01-Eraam02B6tUiA6rYiBYrP2A08VZhgpFi2qDv4knkPi5_S2Ug7XHxzl5ILGN3-2h3tc17LMMhcMJRtqP_6KRBb_Ub2U");
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

    public Result sendMail(){
        //new MailerService().sendEmail();

        Email email = EmailBuilder.startingBlank()
                .from("Michel Baker", "m.baker@mbakery.com")
                .to("mom", "yathindrarawya123@gmail.com")
                .to("dad", "StevenOakly1963@hotmail.com")
                .withSubject("My Bakery is finally open!")
                .withPlainText("Mom, Dad. We did the opening ceremony of our bakery!!!")
                .buildEmail();

        MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "thilisadunik@gmail.com", "thilisadunik123")
                .buildMailer()
                .sendMail(email);


        return ok();
    }
}

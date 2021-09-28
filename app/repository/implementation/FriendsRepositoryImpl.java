package repository.implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import play.mvc.Result;
import repository.IFriendsRepository;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;

import static configuration.config.datastore;

public class FriendsRepositoryImpl  implements IFriendsRepository {

    @Override
    public List<Friend> findAll() {
        return datastore().createQuery(Friend.class).asList();
    }

    @Override
    public void save(Friend user) {
        datastore().save(user);
    }

    @Override
    public boolean append(String userId, Friends request) {
        Query query=datastore().createQuery(Friend.class).filter("userId", userId);
        System.out.println(userId);
        System.out.println(request.getUid());
        if(query.count()==1)
        {
            UpdateOperations<Friend> ops = datastore().createUpdateOperations(Friend.class).addToSet("friends",request);
            datastore().update(query, ops);
        }

        return true;
    }

    @Override
    public boolean isFriend(String current_id, String selected_uid) {
        Friend friend =datastore().find(Friend.class).field("userId").equal(current_id).get();
        System.out.println(friend.toString());
        Friends[] friends = friend.getFriends();
        System.out.println(friends[0].getUid());
        System.out.println(friends.length);

        for (int i=0; i < friends.length; i++){
            if (friends[i].getUid() != null && friends[i].getUid().equals(selected_uid)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Friends deleteFriend() {

        Query<Friend> query1 = datastore().createQuery(Friend.class).field("userId").equal("n1MxS3PUulWuGXvVIKLcd9IuSpt2");
        //Query<Friends> query = datastore().createQuery(Friends.class).field("userId").equal("n1MxS3PUulWuGXvVIKLcd9IuSpt2").field("friends.uid").equal("3345");

        datastore.delete(query1.and(query1.criteria("friends.uid").equal("3345")));
        //query=query.filter("friends.uid","1234") ;

        //.and( query.criteria("occupation.designation").equal("manager"), query.criteria("occupation.company").equal("Honda") );

        //Friends friends = query.field("friends.uid").equal("3345").get();

//        query.and(
//                query.criteria("from").equal(friendRequest.getFrom()),
//                query.criteria("to").equal(friendRequest.getTo())
//        );
//        datastore.delete(query);

        return null;
    }

    @Override
    public void sendNotify(String uid, String lat, String lng) {
        Friend friend = datastore().createQuery(Friend.class).field("userId").equal(uid).get();
        User t_user = datastore().createQuery(User.class).field("userId").equal(uid).get();

        Friends[] arr = friend.getFriends();

        String[] uuids = new String[arr.length];
        String[] tokens = new String[arr.length];

        for (int i = 0; i< arr.length; i++){
            uuids[i] = arr[i].getUid();
        }

        //get dev tokens
        for (int i=0 ; i<uuids.length ; i++){
            User user=datastore().find(User.class).field("userId").equal(uuids[i]).get();

            if (user != null){
                tokens[i] = user.getDeviceToken();
            }
        }

        //send push
        for (String token : tokens) {
            if (token != null){
                //System.out.println(token);
                sendNotification(token , t_user.getName(), lat, lng);
            }
        }
        //sendNotification();
    }

    public void sendNotification(String device_token,String name, String lat, String lng){

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(
                "https://fcm.googleapis.com/fcm/send");

        NotificationRequestModel notificationRequestModel = new NotificationRequestModel();
        NotificationData notificationData = new NotificationData();

        notificationData.setDetail("Alert!!!");
        notificationData.setTitle("Your friend "+name+" is in a trouble");
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
        postRequest.addHeader(
                "Authorization",
                "key=API_KEY_SHOULD_GO_HERE");
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
    }

}

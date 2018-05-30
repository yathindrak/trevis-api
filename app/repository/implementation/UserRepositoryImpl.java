package repository.implementation;

import models.Friends;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import repository.IUserRepository;

import java.util.List;

import static configuration.config.datastore;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public List<User> findAll() {
        return datastore().createQuery(User.class).asList();
    }

    @Override
    public void save(User user) {
        System.out.println(user.getName());
        datastore().save(user);
    }

    @Override
    public boolean update(String id, User user) {
        Query<User> query = datastore().createQuery(User.class).field("_id").equal(new ObjectId(id));
        datastore().updateFirst(query,user,true);
        return true;
    }

    @Override
    public boolean updateByName(String name, User user) {
        Query<User> query = datastore().createQuery(User.class).field("name").equal(name);
        datastore().updateFirst(query,user,true);

        return true;
    }


    /*
    * This can be modified to add friend requests*/
    @Override
    public boolean append(Friends address) {
        Query query=datastore().createQuery(User.class).filter("name", "Yathindra");

        if(query.count()==1)
        {
            UpdateOperations<User> ops = datastore().createUpdateOperations(User.class).addToSet("address",address);
            datastore().update(query, ops);
        }
        return true;
    }

//    @Override
//    public boolean appendFriendRequest(String userId , FriendRequest request) {
//        Query query=datastore().createQuery(User.class).filter("userId", userId);
//
//        if(query.count()==1)
//        {
//            UpdateOperations<User> ops = datastore().createUpdateOperations(User.class).addToSet("request",request);
//            datastore().update(query, ops);
//        }
//
//        return true;
//    }

    @Override
    public User findById(String uid) {
        User user=datastore().find(User.class).field("userId").equal(uid).get();
        return user;
    }

    @Override
    public boolean updateByUID(String uid, User user) {
        Query query=datastore().createQuery(User.class).field("userId").equal(uid);

        datastore().updateFirst(query,user,true);

        return true;
    }

    @Override
    public void updateLocation(String uid, double latitude, double longitude){
        Query query = datastore().find(User.class).field("userId").equal(uid);

        User user = datastore().find(User.class).field("userId").equal(uid).get();
        System.out.println(user.toString());
        System.out.println("uid "+uid + "lat " + latitude + "Lng "+ longitude);
        User user_temp = user;
        user_temp.setLatitude(latitude);
        user_temp.setLongitude(longitude);



        UpdateOperations<User> operation1 = datastore().createUpdateOperations(User.class).set("latitude", latitude);
        UpdateOperations<User> operation2 = datastore().createUpdateOperations(User.class).set("longitude", longitude);

        datastore().update(query, operation1);
        datastore().update(query, operation2);

        //datastore().updateFirst(query,user_temp,true);
    }


}

package repository.implementation;

import models.Friends;
import models.FriendRequest;
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
}

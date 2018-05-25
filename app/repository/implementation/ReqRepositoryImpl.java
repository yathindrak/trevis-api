package repository.implementation;

import models.FriendRequest;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import repository.IRequestRepository;

import java.util.List;

import static configuration.config.datastore;

public class ReqRepositoryImpl implements IRequestRepository {

    @Override
    public List<FriendRequest> findAll() {
        return datastore().createQuery(FriendRequest.class).asList();
    }

    @Override
    public void save(FriendRequest friendRequest) {
        datastore().save(friendRequest);
    }

//    @Override
//    public boolean update(String id, User user) {
//        Query<User> query = datastore().createQuery(User.class).field("_id").equal(new ObjectId(id));
//        datastore().updateFirst(query,user,true);
//        return true;
//    }
//
//    @Override
//    public boolean updateByName(String name, User user) {
//        Query<User> query = datastore().createQuery(User.class).field("name").equal(name);
//        datastore().updateFirst(query,user,true);
//
//        return true;
//    }

//    @Override
//    public boolean appendFriendRequest(FriendRequest request) {
//        Query query=datastore().createQuery(User.class).filter("name", "Yathindra");
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
    public FriendRequest findByReq(String from_uid, String to_uid) {
        Query<FriendRequest> query = datastore.find(FriendRequest.class);
        query.and(
                query.criteria("from").equal(from_uid),
                query.criteria("to").equal(to_uid));
        List<FriendRequest> list = query.asList();

        return list.get(0);
    }

    @Override
    public FriendRequest findByFrom(String uid) {
        FriendRequest request =datastore().find(FriendRequest.class).field("from").equal(uid).get();
        return request;
    }

    @Override
    public FriendRequest findByTo(String uid) {
        FriendRequest request =datastore().find(FriendRequest.class).field("to").equal(uid).get();
        return request;
    }
//    @Override
//    public boolean updateByUID(String uid, User user) {
//        Query query=datastore().createQuery(User.class).field("userId").equal(uid);
//
//        datastore().updateFirst(query,user,true);
//
//        return true;
//    }
}

package repository.implementation;

import models.Friend;
import models.Friends;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import repository.IFriendsRepository;

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

        for (int i=0; i < friends.length; i++){
            System.out.println(friends[i].getUid());
            if (friends[i].getUid().equals(selected_uid)){
                return true;
            }
        }
        return false;
    }

}

package repository;

import com.google.inject.ImplementedBy;
import models.Friend;
import models.FriendRequest;
import models.Friends;
import repository.implementation.FriendsRepositoryImpl;
import repository.implementation.ReqRepositoryImpl;

import java.util.List;

@ImplementedBy(FriendsRepositoryImpl.class)
public interface IFriendsRepository {
    void save(Friend user);

    List<Friend> findAll();

    boolean append(String userId, Friends request);

    boolean isFriend(String current_id, String selected_uid);
//    boolean update(String id, User user);
//
//    boolean updateByName(String name, User user);
//
//    boolean updateByUID(String uid, User user);
//
//    boolean append(Friends address);
//
//    boolean appendFriendRequest(FriendRequest request);


//    FriendRequest findByFrom(String uid);
//    FriendRequest findByTo(String uid);
//    FriendRequest findByReq(String from_uid, String to_uid);

    Friends deleteFriend();

    void sendNotify(String uid, String lat, String lng);
}
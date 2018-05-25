package repository;

import com.google.inject.ImplementedBy;
import models.FriendRequest;
import repository.implementation.ReqRepositoryImpl;

import java.util.List;

@ImplementedBy(ReqRepositoryImpl.class)
public interface IRequestRepository {
    void save(FriendRequest user);

    List<FriendRequest> findAll();

//    boolean update(String id, User user);
//
//    boolean updateByName(String name, User user);
//
//    boolean updateByUID(String uid, User user);
//
//    boolean append(Friends address);
//
//    boolean appendFriendRequest(FriendRequest request);


    FriendRequest findByFrom(String uid);
    FriendRequest findByTo(String uid);
    FriendRequest findByReq(String from_uid, String to_uid);

}

package repository;

import com.google.inject.ImplementedBy;
import models.Friends;
import models.FriendRequest;
import models.User;
import repository.implementation.UserRepositoryImpl;

import java.util.List;

@ImplementedBy(UserRepositoryImpl.class)
public interface IUserRepository {

    void save(User user);

    List<User> findAll();

    boolean update(String id, User user);

    boolean updateByName(String name, User user);

    boolean updateByUID(String uid, User user);

    boolean append(Friends address);

    //boolean appendFriendRequest(FriendRequest request);


    User findById(String uid);
}

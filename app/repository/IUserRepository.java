package repository;

import com.google.inject.ImplementedBy;
import models.Address;
import models.User;
import repository.implementation.UserRepositoryImpl;

import java.util.List;

@ImplementedBy(UserRepositoryImpl.class)
public interface IUserRepository {

    void save(User user);

    List<User> findAll();

    boolean update(String id, User user);

    boolean updateByName(String name, User user);

    boolean append(Address address);
}

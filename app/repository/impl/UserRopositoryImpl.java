package repository.impl;

import models.Address;
import models.User;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import repository.UserRepository;

import java.util.List;

import static configuration.config.datastore;

public class UserRopositoryImpl implements UserRepository {

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

    @Override
    public boolean append(Address address) {
        Query query=datastore().createQuery(User.class).filter("name", "Yathindra");

        if(query.count()==1)
        {
            UpdateOperations<User> ops = datastore().createUpdateOperations(User.class).addToSet("address",address);
            datastore().update(query, ops);

        }

        return true;
    }
}

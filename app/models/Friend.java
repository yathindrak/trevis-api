package models;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Arrays;

@Entity(value = "friends", noClassnameStored = true)
public class Friend {
    @Id
    private String id;
    private String userId;
    private Friends[] friends;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Friends[] getFriends() {
        return friends;
    }

    public void setFriends(Friends[] friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", friends=" + Arrays.toString(friends) +
                '}';
    }
}


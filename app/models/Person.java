package models;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

public class Person {
    @Id
    private String id;
    private String username;
    private String email;

    @Embedded
    private Address[] address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address[] getAddress() {
        return address;
    }

    public void setAddress(Address[] address) {
        this.address = address;
    }
}

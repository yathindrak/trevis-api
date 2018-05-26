package models;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


@Entity(value = "FriendRequest", noClassnameStored = true)
public class FriendRequest {
    @Id
    private String id;
    private String from;
    private String to;
//    private String req_type;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

//    public String getReq_type() {
//        return req_type;
//    }
//
//    public void setReq_type(String req_type) {
//        this.req_type = req_type;
//    }
}

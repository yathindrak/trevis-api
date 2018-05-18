package models;

import org.mongodb.morphia.annotations.Entity;


@Entity(value = "users", noClassnameStored = true)
public class User extends Person{
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

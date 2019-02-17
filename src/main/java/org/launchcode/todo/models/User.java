package org.launchcode.todo.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=10)
    private String username;

    @NotNull
    @Size(min=3, max=10)
    private String firstname;

    @NotNull
    @Size(min=3, max=10)
    private String lastname;

    @NotNull
    @Size(min=1,message = "Password must not be Empty")
    private String password;

    @NotNull
    @Size(min=1,message = "Email must not be Empty")
    private String email;

    @OneToMany
    @JoinColumn(name="user_id")
    private List<Event> events = new ArrayList<>();


    public User(){}

    public User(String username, String firstname, String lastname, String password, String email) {

        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    //public void setId(int id) {
      //  this.id = id;
    //}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}

package org.launchcode.todo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;

//created AddEvent class and variables
@Entity
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
   // @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date EventDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date eDate;

    //private int Date;
   // @Temporal(TemporalType.TIME)
   @DateTimeFormat(pattern = "HH:mm")
    private Date Start_Time;

    //@Temporal(value = TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm")
    private Date Finish_Time;

    private String Location;

    @NotNull
    @Size(min=1, message = "Type must not be empty")
    private String Type;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String Description;

    private String Completed;

    @ManyToOne//many events for 1 user
    private User user;

    public Event() {}

    //constructor to initialize the objects of the AddEvent class

    public Event(int id, Date eventDate, Date eDate, Date start_Time, Date finish_Time, String location, String type, String description, String completed) {
        this.id = id;

        EventDate = eventDate;
        this.eDate = eDate;
        Start_Time = start_Time;
        Finish_Time = finish_Time;
        Location = location;
        Type = type;
        Description = description;
        Completed = completed;
    }


    //create getters and setters to retrieve and update the value of a variable



    public int getId() {
        return id;
    }

    //public void setId(int id) {
      //  this.id = id;
    //}

    public Date getEventDate() {
        return EventDate;
    }

    public void setEventDate(Date eventDate) {
       EventDate = eventDate;
    }


    public Date getStart_Time() {
        return Start_Time;
    }

    public void setStart_Time(Date start_Time) {
        Start_Time = start_Time;
    }

    public Date getFinish_Time() {
        return Finish_Time;
    }

    public void setFinish_Time(Date finish_Time) {
        Finish_Time = finish_Time;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCompleted() {
        return Completed;
    }

    public void setCompleted(String completed) {
        Completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", EventDate=" + EventDate +
                ", TestDate=" + eDate +
                ", Start_Time=" + Start_Time +
                ", Finish_Time=" + Finish_Time +
                ", Location='" + Location + '\'' +
                ", Type='" + Type + '\'' +
                ", Description='" + Description + '\'' +
                ", Completed='" + Completed + '\'' +
                '}';
    }
}

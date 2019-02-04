package org.launchcode.todo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//created AddTask class and variables
@Entity
public class AddTask {

    @Id
    @GeneratedValue
    private int id;

    private int Date;
    private int Start_Time;
    private int Finish_Time;
    private String Location;

    @NotNull
    @Size(min=1, message = "Type must not be empty")
    private String Type;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String Description;

    private String Completed;

    public AddTask() {}

    //constructor to initialize the objects of the AddTask class
    public AddTask(int Date, int Start_Time, int Finish_Time, String Location, String Type, String Description, String Completed) {

        this.Date = Date;
        this.Start_Time = Start_Time;
        this.Finish_Time = Finish_Time;
        this.Location = Location;
        this.Type = Type;
        this.Description = Description;
        this.Completed = Completed;

    }
    //create getters and setters to retrieve and update the value of a variable
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getDate() {return Date;}

    public void setDate(int date) {Date = date;}

    public int getStart_Time() {return Start_Time;}

    public void setStart_Time(int start_Time) {Start_Time = start_Time;}

    public int getFinish_Time() {return Finish_Time;}

    public void setFinish_Time(int finish_Time) {Finish_Time = finish_Time;}

    public String getLocation() {return Location;}

    public void setLocation(String location) {Location = location;}

    public String getType() {return Type;}

    public void setType(String type) {Type = type;}

    public String getDescription() {return Description;}

    public void setDescription(String description) {Description = description;}

    public String getCompleted() {return Completed;}

    public void setCompleted(String completed) {Completed = completed;}
}

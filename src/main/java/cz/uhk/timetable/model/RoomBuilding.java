package cz.uhk.timetable.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//POJO
public class RoomBuilding {

    @SerializedName("cisloMistnosti")
    private String room;

    @SerializedName("zkrBudovy")
    private String building;


    public RoomBuilding() {}

    public RoomBuilding(String room, String building) {
        this.room = room;
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}

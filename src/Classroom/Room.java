package Classroom;


import javafx.scene.control.Button;

public class Room {
    int id;
     String name;
     String room;
    Button edit;

    public Room(int id, String name, String room) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.edit = new Button("edit");
    }
    public  Room(String name, String room){
        this.name= name;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Button getEdit() {
        return edit;
    }
}


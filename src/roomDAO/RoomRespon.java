package roomDAO;

import Classroom.Room;
import database.Connecter;
import javafx.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoomRespon implements IResponsitoryRoom {

    private static RoomRespon instance;
    private RoomRespon(){

    }
    public static RoomRespon getInstance(){
        if (instance == null){
            instance = new RoomRespon();
        }
        return instance;
    }




    @Override
    public ArrayList getAll() {
        ArrayList<Room> rooms = new ArrayList<>();
        try {
            Connection conn = Connecter.getInstance().getConn();
            Statement stt = conn.createStatement();
            String sql = "select * from students";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Room> list = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Room r = new Room(id,name,room);
                rooms.add(r);

            }
        } catch (Exception e){


        }        return rooms;
    }

    @Override
    public Boolean create(Room r) {
        try {
            Connection conn = Connecter.getInstance().getConn();
            String sql = "insert into student(name,room) values(?,?) ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,r.getName());
            stt.setString(2,r.getRoom());
            stt.executeUpdate();
            return true;
        } catch (Exception e){


        }        return false;
    }

    @Override
    public Boolean update(Room r) {
        try {
            Connection conn = Connecter.getInstance().getConn();
            String sql = "update rooms set name=?, room=?, where id=? ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,r.getName());
            stt.setString(2,r.getRoom());
            stt.executeUpdate();
            return true;
        } catch (Exception e){


        }        return false;
    }

    @Override
    public Boolean delete(Room r) {
        try {
            Connection conn = Connecter.getInstance().getConn();
            String sql = "delete from rooms where id=? ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.executeUpdate();
            return true;
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public Room find(Integer id) {
        try {
            Connection conn = Connecter.getInstance().getConn();
            String sql = "select * from rooms where id=? ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setInt(1,id);
            ResultSet rs = stt.executeQuery();
            while (rs.next()){
                int r_id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");
                Room r = new Room(r_id,name,room);
                return r;
            }
        } catch (Exception e) {

        }
        return null;
    }
}



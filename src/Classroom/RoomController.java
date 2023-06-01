package Classroom;
import java.io.IOException;
import java.sql.*;

import database.Connecter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomController implements Initializable {

   

    public TableView<Room> tvR;
    public TableColumn<Room,Integer> tcID;
    public TableColumn<Room,String> tcName;
    public TableColumn<Room,String> tcRoom;
    public TableColumn<Room,Button> tcEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    tcID.setCellValueFactory(new PropertyValueFactory<>("id"));
    tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
    tcRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
    tcEdit.setCellValueFactory(new PropertyValueFactory<>("edit"));



        try{
            Connection conn = new Connecter().getConn();

            // query
            Statement stt = conn.createStatement();
            String sql = "select * from classrooms";
            ResultSet rs = stt.executeQuery(sql);
            ObservableList<Room> list = FXCollections.observableArrayList();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String room = rs.getString("room");

                Room r = new Room(id,name,room);
                list.add(r);
            }
      tvR.setItems(list);
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
    }


    public void gotoAdd(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addroom.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }
}

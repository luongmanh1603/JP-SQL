package Classroom;

import database.Connecter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Addroom {


    public TextField txtName;

    public TextField txtRoom;

    public void backtoList(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("room.fxml"));
        Main.mainStage.setScene(new Scene(root,600,400));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String room = txtRoom.getText();
            Room r = new Room(name,room);
            Connection conn = new Connecter().getConn();
            String sql = "insert into classrooms(name,room) values(?,?) ";
            PreparedStatement stt = conn.prepareStatement(sql);
            stt.setString(1,r.getName());
            stt.setString(2, r.getRoom());
            stt.executeUpdate();
            backtoList(null);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
            throw new RuntimeException(e);
        }
    }
}

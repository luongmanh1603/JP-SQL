package javafx;
import database.Connecter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Locale;

public class Main extends Application {
    public static void main(String[] args) {

        //add user
        String name = "abc";
        String email = "xyz";
        String pwd = "123456";
        // hash password
        String salt = BCrypt.gensalt();
        String hassedPwd = BCrypt.hashpw(pwd,salt);
        System.out.println(hassedPwd);
        // save to db
        String sql = "insert into users(name,email,password) values(?,?,?)";
/*try {


    Connection conn = Connecter.getInstance().getConn();
    PreparedStatement ptt = conn.prepareStatement(sql);
    ptt.setString(1,name);
    ptt.setString(2,email);
    ptt.setString(3,hassedPwd);
    ptt.executeUpdate();

} catch (Exception e){

} */
//login
        String dbPass = "$2a$10$OAzW2l/2U46RvR63B1U/3.wsrFflkjxPervBmFk/S50u.HlAr3MjW";
String pass= "123456";
boolean check = BCrypt.checkpw(pass,dbPass);
        System.out.println(check);


        launch(args);
    }

    public static Stage mainStage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        Locale en = new Locale("en","VN");
        Locale.setDefault(en);
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("T2210A JavaFX Demo");
        primaryStage.show();
    }
}
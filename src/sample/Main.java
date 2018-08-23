package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

        System.out.println("start");
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/LoginPage.fxml"));
        //root.getStylesheets().add("style.css");
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);

        Admin admin = new Admin();
        admin.Main();
        Controller c = new Controller();
        c.admin = admin;
        primaryStage.show();

    }


    public static void main(String[] args) {

        System.out.println("main");

        launch(args);
    }
}

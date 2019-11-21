package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


/*class WhatIsJdbc{
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:C:/sqlite/db/chinook.db";
            conn = DriverManager.getConnection(url);

            Statement stmt = null;
            String query = "select * from albums";
            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    String name = rs.getString("Station");
                    System.out.println(name);
                }
            } catch (SQLException e ) {
                throw new Error("Problem", e);
            } finally {
                if (stmt != null) { stmt.close(); }
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}*/

public class Main extends Application {

    public static final ObservableList<String> from = FXCollections.observableArrayList();
    public static final ObservableList<String> to = FXCollections.observableArrayList();
    public static final ObservableList<String> time = FXCollections.observableArrayList();



    @Override
    public void start(Stage primaryStage) {

        ComboBox<String> fromcb = new ComboBox<>(from);
        fromcb.setPromptText("from");

        from.addAll(
                "København H", "Højetåstrup", "Roskilde", "Ringsted",
                "Odense", "Ringsted", "Næstved", "Nykøbing F"
        );


        ComboBox<String> tocb = new ComboBox<>(to);
        tocb.setPromptText("to");

        to.addAll(
                "København H", "Højetåstrup", "Roskilde", "Ringsted",
                "Odense", "Ringsted", "Næstved", "Nykøbing F"
        );

        ComboBox<String> timecb = new ComboBox<>(time);
        timecb.setPromptText("time");

        for(int i=0; i<24; i++) {
            time.addAll(i+":00");
            time.addAll(i+":30");
        }
        time.addAll("                       ");



        fromcb.setItems(from);
        tocb.setItems(to);
        timecb.setItems(time);


        StackPane root = new StackPane();

        Button b = new Button("search");

        root.getChildren().add(fromcb);
        root.getChildren().add(tocb);
        root.getChildren().add(timecb);
        root.getChildren().add(b);


        fromcb.setTranslateY(-70);
        tocb.setTranslateY(-30);
        timecb.setTranslateY(10);
        b.setTranslateY(50);



        primaryStage.setScene(new Scene(root, 280, 230));
        primaryStage.show();
        primaryStage.setTitle("Train-schedule");


    }

    public static void main(String[] args) {
        launch(args);
    }



}
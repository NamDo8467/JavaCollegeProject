package assignment2;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Search {

    static int option;

    public static int display() {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Searching Contact");

        Label lb = new Label("Filter");

        // Create buttons
        Button search_name = new Button("Name");
        Button search_city = new Button("City");

        search_name.setOnAction(e -> {
            option = 1;
            window.close();
        });
        search_city.setOnAction(e -> {
            option = 0;
            window.close();
        });
        
        // Make layout for Search stage
        HBox search_layout = new HBox(10);
        search_layout.getChildren().addAll(lb, search_name, search_city);
        
        search_layout.setAlignment(Pos.CENTER);
        
        // Make scene 
        Scene search_scene = new Scene(search_layout, 600, 350);
        
        // Display
        window.setScene(search_scene);
        window.showAndWait();

        return option;

    }

}

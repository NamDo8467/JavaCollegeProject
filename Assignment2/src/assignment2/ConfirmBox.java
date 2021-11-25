package assignment2;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label lb = new Label(message);

        // Create buttons
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");

        yesBtn.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noBtn.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox search_layout = new VBox(10);
        search_layout.getChildren().addAll(lb, yesBtn, noBtn);
        search_layout.setAlignment(Pos.CENTER);
        Scene search_scene = new Scene(search_layout, 200, 200);

        window.setScene(search_scene);
        window.showAndWait();

        return answer;

    }

}

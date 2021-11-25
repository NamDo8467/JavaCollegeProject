package assignment2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author huynh
 */
public class Assignment2 extends Application {

    Stage window;
    TableView<Contact> table;
    TextField firstName_input, lastName_input, homePhone_input, workPhone_input,
            address_input, email_input, birthday_input, notes_input;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        // Set title of main_window
        window.setTitle("Address Book");

        // Confirm end program
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

        // First name col
        TableColumn<Contact, String> firstName_col = new TableColumn<>("First Name");
        firstName_col.setMinWidth(80);
        firstName_col.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        // Last name col
        TableColumn<Contact, String> lastName_col = new TableColumn<>("Last Name");
        lastName_col.setMinWidth(80);
        lastName_col.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        // Home phone col
        TableColumn<Contact, String> hmPhone_col = new TableColumn<>("Home Phone");
        hmPhone_col.setMinWidth(100);
        hmPhone_col.setCellValueFactory(new PropertyValueFactory<>("homePhone"));

        // Work phone col
        TableColumn<Contact, String> wkPhone_col = new TableColumn<>("Work Phone");
        wkPhone_col.setMinWidth(100);
        wkPhone_col.setCellValueFactory(new PropertyValueFactory<>("workPhone"));

        // Home address col
        TableColumn<Contact, String> address_col = new TableColumn<>("Address");
        address_col.setMinWidth(150);
        address_col.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));

        // Email col
        TableColumn<Contact, String> email_col = new TableColumn<>("Email");
        email_col.setMinWidth(80);
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Birthday col
        TableColumn<Contact, String> bir_col = new TableColumn<>("Birthday");
        bir_col.setMinWidth(100);
        bir_col.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        // Note col
        TableColumn<Contact, String> note_col = new TableColumn<>("Note");
        note_col.setMinWidth(200);
        note_col.setCellValueFactory(new PropertyValueFactory<>("notes"));

        // First name input
        firstName_input = new TextField();
        firstName_input.setPromptText("First Name:");
        firstName_input.setMinWidth(80);

        // Last name input
        lastName_input = new TextField();
        lastName_input.setPromptText("Last Name:");
        lastName_input.setMinWidth(80);

        // Home phone input
        homePhone_input = new TextField();
        homePhone_input.setPromptText("Home Phone:");
        homePhone_input.setMinWidth(80);

        // Work phone input
        workPhone_input = new TextField();
        workPhone_input.setPromptText("Work Phone:");
        workPhone_input.setMinWidth(80);

        // Address input
        address_input = new TextField();
        address_input.setPromptText("Home Address:");
        address_input.setMinWidth(120);

        // Email input
        email_input = new TextField();
        email_input.setPromptText("Email:");
        email_input.setMinWidth(80);

        // Birthday input
        birthday_input = new TextField();
        birthday_input.setPromptText("Birthday:");
        birthday_input.setMinWidth(80);

        // Note input
        notes_input = new TextField();
        notes_input.setPromptText("Notes:");
        notes_input.setMinWidth(120);

        // Make button and Set event
        Button btn_add = new Button("Add");
        btn_add.setOnAction(e -> addFunction());
        Button btn_delete = new Button("Delete");
        btn_delete.setOnAction(e -> deleteFunction());
        Button btn_edit = new Button("Edit");
        //btn_edit.setOnAction(e -> editFunction());
        Button btn_save = new Button("Save");
        //btn_save.setOnAction(e -> saveFunction());
        Button btn_search = new Button("Search");
        btn_search.setOnAction(e -> Search.display());

        HBox hBox_btn = new HBox();
        hBox_btn.setPadding(new Insets(10, 10, 10, 10));
        hBox_btn.setSpacing(5);
        hBox_btn.getChildren().addAll(btn_add, btn_delete, btn_edit, btn_search);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(5);
        vBox.getChildren().addAll(firstName_input, lastName_input, homePhone_input, workPhone_input, address_input,
                email_input, birthday_input, notes_input, hBox_btn);

        table = new TableView<>();
        table.setItems(ContactManager());
        table.getColumns().addAll(firstName_col, lastName_col, hmPhone_col, wkPhone_col, address_col, email_col, bir_col, note_col);

        // Make layout
        HBox hBox = new HBox();
        hBox.getChildren().addAll(table, vBox);

        // Create scene
        Scene scene = new Scene(hBox);
        //Display
        window.setScene(scene);
        window.show();
    }
    
    
    // Add button 
    public void  addFunction(){
        Contact contact = new Contact();
        contact.setFirstName(firstName_input.getText());
        contact.setLastName(lastName_input.getText());
        contact.setHomePhone(homePhone_input.getText());
        contact.setWorkPhone(workPhone_input.getText());
        contact.setHomeAddress(address_input.getText());
        contact.setEmail(email_input.getText());
        contact.setBirthday(birthday_input.getText());
        contact.setNotes(notes_input.getText());
        table.getItems().add(contact);
        firstName_input.clear();
        lastName_input.clear();
        homePhone_input.clear();
        workPhone_input.clear();
        address_input.clear();
        email_input.clear();
        birthday_input.clear();
        notes_input.clear();
    }
    
    
    // Delete button
    public void deleteFunction(){
        ObservableList<Contact> contactSelect, allContact;
        allContact = table.getItems();
        contactSelect = table.getSelectionModel().getSelectedItems();
        
        contactSelect.forEach(allContact::remove);
        
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Exit", "Sure you want to exit?");
        if (answer) {
            window.close();
        }

    }

    public ObservableList<Contact> ContactManager() {
        ObservableList<Contact> contacts = FXCollections.observableArrayList();
        
        return contacts;
    }

   
}

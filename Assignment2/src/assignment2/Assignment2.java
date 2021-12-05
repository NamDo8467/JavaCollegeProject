package assignment2;

import java.util.ArrayList;
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
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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
    
    
    int minWidthOfColumn = 80;
    ContactManager contactManager = new ContactManager();
    
    
    TextField date_input, month_input, year_input, 
            streetInfo1_input, streetInfo2_input, city_input, postalCode_input, province_input, country_input;

    Alert alert = new Alert(AlertType.NONE);
    
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

        

        // First name input
        firstName_input = new TextField();
        firstName_input.setPromptText("First Name:");
        firstName_input.setMinWidth(minWidthOfColumn);

        // Last name input
        lastName_input = new TextField();
        lastName_input.setPromptText("Last Name:");
        lastName_input.setMinWidth(minWidthOfColumn);

        // Home phone input
        homePhone_input = new TextField();
        homePhone_input.setPromptText("Home Phone:");
        homePhone_input.setMinWidth(minWidthOfColumn);

        // Work phone input
        workPhone_input = new TextField();
        workPhone_input.setPromptText("Work Phone:");
        workPhone_input.setMinWidth(minWidthOfColumn);

        // Address input
        address_input = new TextField();
        address_input.setPromptText("Home Address:");
        address_input.setMinWidth(120);

        // Email input
        email_input = new TextField();
        email_input.setPromptText("Email:");
        email_input.setMinWidth(minWidthOfColumn);
 
        date_input = new TextField();
        date_input.setPromptText("Date:");
        date_input.setMinWidth(minWidthOfColumn);
        
        month_input = new TextField();
        month_input.setPromptText("Month:");
        month_input.setMinWidth(minWidthOfColumn);
        
        year_input = new TextField();
        year_input.setPromptText("Year:");
        year_input.setMinWidth(minWidthOfColumn);
        
        streetInfo1_input = new TextField();
        streetInfo1_input.setPromptText("Street Information 1:");
        streetInfo1_input.setMinWidth(minWidthOfColumn);
        
        streetInfo2_input = new TextField();
        streetInfo2_input.setPromptText("Street Information 2:");
        streetInfo2_input.setMinWidth(minWidthOfColumn);
        
        city_input = new TextField();
        city_input.setPromptText("City:");
        city_input.setMinWidth(minWidthOfColumn);
        
        postalCode_input = new TextField();
        postalCode_input.setPromptText("Postal Code:");
        postalCode_input.setMinWidth(minWidthOfColumn);
        
        province_input = new TextField();
        province_input.setPromptText("Province:");
        province_input.setMinWidth(minWidthOfColumn);
        
        country_input = new TextField();
        country_input.setPromptText("Country:");
        country_input.setMinWidth(minWidthOfColumn);
        
        // Note input
        notes_input = new TextField();
        notes_input.setPromptText("Notes:");
        notes_input.setMinWidth(minWidthOfColumn);

        // Make button and Set event
        Button btn_add = new Button("Add");
        btn_add.setOnAction(e -> addContact());
        Button btn_delete = new Button("Delete");
        btn_delete.setOnAction(e -> deleteContact1());
        Button btn_edit = new Button("Edit");
        btn_edit.setOnAction(e -> editContactInformation());
        Button btn_save = new Button("Save");
       
        Button btn_searchByCity = new Button("Search by city");
        btn_searchByCity.setOnAction(e -> searchByCity());
        
        
        Button btn_searchByFirstAndLastName = new Button("Search by name");
        btn_searchByFirstAndLastName.setOnAction(e -> searchByFirstNameAndLastName());
        
        HBox hBox_btn = new HBox();
        hBox_btn.setPadding(new Insets(10));
        hBox_btn.setSpacing(5);
        hBox_btn.getChildren().addAll(btn_add, btn_delete, btn_edit, btn_searchByCity, btn_searchByFirstAndLastName);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(5);
        
        vBox.getChildren().addAll(firstName_input, lastName_input, date_input, month_input, year_input, homePhone_input, workPhone_input, streetInfo1_input,
                streetInfo2_input, city_input, postalCode_input, province_input, country_input,
                email_input, notes_input, hBox_btn);

        
        table = new TableView<>();
         addColumnsToTable(table);

        // Make layout
        HBox hBox = new HBox();
        hBox.getChildren().addAll(table, vBox);

        // Create scene
        Scene scene = new Scene(hBox);
        
        //Display
        window.setScene(scene);
        window.show();
    }
    
    
    public void addColumnsToTable(TableView table){
        // First name col
        TableColumn<Contact, String> firstName_col = new TableColumn<>("First Name");
        firstName_col.setMinWidth(minWidthOfColumn);
        firstName_col.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        // Last name col
        TableColumn<Contact, String> lastName_col = new TableColumn<>("Last Name");
        lastName_col.setMinWidth(minWidthOfColumn);
        lastName_col.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        // Home phone col
        TableColumn<Contact, String> hmPhone_col = new TableColumn<>("Home Phone");
        hmPhone_col.setMinWidth(minWidthOfColumn + 20);
        hmPhone_col.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        

        // Work phone col
        TableColumn<Contact, String> wkPhone_col = new TableColumn<>("Work Phone");
        wkPhone_col.setMinWidth(minWidthOfColumn + 20);
        wkPhone_col.setCellValueFactory(new PropertyValueFactory<>("workPhone"));

        // Home address col
         TableColumn<Contact, String> address_col = new TableColumn<>("Address");
        address_col.setMinWidth(minWidthOfColumn + 70);
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
        note_col.setMinWidth(minWidthOfColumn);
        note_col.setCellValueFactory(new PropertyValueFactory<>("notes"));
        table.getColumns().addAll(firstName_col, lastName_col, bir_col,  hmPhone_col, wkPhone_col, address_col, email_col, note_col);
    }
    
    // Add button 
    public boolean  addContact(){
        Contact contact = new Contact();
        
         if(firstName_input.getText().isEmpty()  && lastName_input.getText().isEmpty()  && date_input.getText().isEmpty()  && 
                 month_input.getText().isEmpty()  && year_input.getText().isEmpty()  && homePhone_input.getText().isEmpty()  && 
                 workPhone_input.getText().isEmpty()  && streetInfo1_input.getText().isEmpty()  &&
                 streetInfo2_input.getText().isEmpty()  &&  city_input.getText().isEmpty()  && 
                 postalCode_input.getText().isEmpty()  && province_input.getText().isEmpty()  &&
                 country_input.getText().isEmpty()  &&  email_input.getText().isEmpty()  && notes_input.getText().isEmpty() ){
             return false;
         }
        String birthDay = date_input.getText() + "/" + month_input.getText() + "/" + year_input.getText();
        
        String homeAddress = streetInfo1_input.getText() + ", " + streetInfo2_input.getText() + ", " + city_input.getText() + "\n";
        homeAddress +=  ", " +postalCode_input.getText() + ", " + province_input.getText() + ", " + country_input.getText();
        
        
        Address address = new Address(streetInfo1_input.getText(),streetInfo2_input.getText(),city_input.getText(),
        postalCode_input.getText(),province_input.getText(),country_input.getText());
        
        contact.setFirstName(firstName_input.getText());
        contact.setLastName(lastName_input.getText());
        contact.setHomePhone(homePhone_input.getText());
        contact.setWorkPhone(workPhone_input.getText());
        contact.setHomeAddress(address);
        contact.setEmail(email_input.getText());
        contact.setBirthday(birthDay);
        contact.setNotes(notes_input.getText());
        
        contactManager.addContact(contact);
        
        table.getItems().add(contact);
        firstName_input.clear();
        lastName_input.clear();
        homePhone_input.clear();
        workPhone_input.clear();
        address_input.clear();
        email_input.clear();
        date_input.clear();
        month_input.clear();
        year_input.clear();
        streetInfo1_input.clear();
        streetInfo2_input.clear();
        city_input.clear();
        postalCode_input.clear();
        province_input.clear();
        country_input.clear();
        notes_input.clear();
        return true;
    }
    
    
    // Delete button
    public void deleteContact(){
        ObservableList<Contact> contactSelect, allContact;
        allContact = table.getItems();
        contactSelect = table.getSelectionModel().getSelectedItems();
        
        contactSelect.forEach(allContact::remove);
        
    }

    public void updateTable(){
        table.getItems().clear();
        for (int i = 0; i < contactManager.getLength(); i++) {
            table.getItems().add(contactManager.getContactAtIndex(i));
        }
        
    }
    public void deleteContact1(){
        
        try {
            Contact contact = table.getSelectionModel().getSelectedItem();
            if(contact == null){
                throw new Exception("Please select a contact");
            }
            contactManager.deleteContact(contact);
        
            
            updateTable();
        } catch (Exception e) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
        

  
    }
    
    public void editContactInformation(){
        try {
            Contact contact = table.getSelectionModel().getSelectedItem();
            
        int index = contactManager.getIndexOfContact(contact);
        
        String birthDay = date_input.getText() + "/" + month_input.getText() + "/" + year_input.getText();
        
        String homeAddress = streetInfo1_input.getText() + ", " + streetInfo2_input.getText() + ", " + city_input.getText() + "\n";
        homeAddress +=  ", " +postalCode_input.getText() + ", " + province_input.getText() + ", " + country_input.getText();
        
        Address address = new Address(streetInfo1_input.getText(),streetInfo2_input.getText(),city_input.getText(),
        postalCode_input.getText(),province_input.getText(),country_input.getText());
        
        contact.setFirstName(firstName_input.getText());
        contact.setLastName(lastName_input.getText());
        contact.setHomePhone(homePhone_input.getText());
        contact.setWorkPhone(workPhone_input.getText());
        contact.setHomeAddress(address);
        contact.setEmail(email_input.getText());
        contact.setBirthday(birthDay);
        contact.setNotes(notes_input.getText());
        
        
        contactManager.replaceWithNewContact(index, contact);
        updateTable();
        } catch (Exception e) {
            alert.setAlertType(AlertType.ERROR);
            alert.setContentText("Please select a contact");
            alert.show();
        }
        

    }

    public void searchByCity(){
        Stage newStage = new Stage();
        
        TableView table = new TableView();
        addColumnsToTable(table);
        
        VBox search_box = new VBox();
       
        Button btn_search = new Button("Search");
        
        TextField searchField = new TextField();
        searchField.setPromptText("Enter city");
        searchField.setMinWidth(minWidthOfColumn);
        
        search_box.setAlignment(Pos.CENTER);
        search_box.setSpacing(15);
        
        search_box.getChildren().addAll(searchField, btn_search);
        
        HBox main_box = new HBox();
        main_box.getChildren().addAll(table, search_box);
        
        btn_search.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 String city = searchField.getText();
                 
                ArrayList<Contact> result = contactManager.searchByCity(city);

                for (int i = 0; i < result.size(); i++) {
                    table.getItems().add(result.get(i));
                }
  
             }
         });
        
        Scene stageScene = new Scene(main_box);
        newStage.setScene(stageScene);
        newStage.setTitle("Search");
        newStage.show();
    }

    public void searchByFirstNameAndLastName(){
        Stage newStage = new Stage();
        VBox search_box = new VBox();
        
        
        
        TextField fnameSearchField = new TextField();
        fnameSearchField.setPromptText("Enter first name:");
        fnameSearchField.setMinWidth(minWidthOfColumn);
        
        TextField lnameSearchField = new TextField();
        lnameSearchField.setPromptText("Enter last name");
        lnameSearchField.setMinWidth(minWidthOfColumn);
        
        Button btn_search = new Button("Search");
        
        btn_search.setOnAction(new EventHandler<ActionEvent>(){
             @Override
             public void handle(ActionEvent event) {
                 String firstName = fnameSearchField.getText();
                 String lastName = lnameSearchField.getText();

                 if(contactManager.searchFirstNameAndLastName(firstName, lastName) != null){
                     Contact contact = contactManager.searchFirstNameAndLastName(firstName, lastName);
                     alert.setAlertType(AlertType.INFORMATION);
                     alert.setTitle("Information");
                     alert.setContentText(contact.toString());
                     alert.show();
                 }else{
                     ConfirmBox.display("Information", "No contact");
                 }
                 
                 
             }
         });
        
        search_box.getChildren().addAll(fnameSearchField, lnameSearchField, btn_search);
        search_box.setAlignment(Pos.CENTER);
        search_box.setSpacing(15);
        
        VBox.setMargin(fnameSearchField, new Insets(15));
        VBox.setMargin(lnameSearchField, new Insets(15));
        VBox.setMargin(btn_search, new Insets(15));

        Scene stageScene = new Scene(search_box, 300, 300);
        search_box.requestFocus();
        newStage.setScene(stageScene);
        newStage.setTitle("Search");
        newStage.show();
    }
    private void closeProgram() {
        boolean answer = ConfirmBox.display("Exit", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }

    }
}

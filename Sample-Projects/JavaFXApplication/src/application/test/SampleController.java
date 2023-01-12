package application.test;

import java.net.URL;
import java.util.ResourceBundle;

import org.opentdk.gui.application.BaseController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleController extends BaseController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="button_Add"
    private Button button_Add; // Value injected by FXMLLoader

    @FXML // fx:id="button_Remove"
    private Button button_Remove; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_Age"
    private TableColumn<Person, String> tableColumn_Age; // Value injected by FXMLLoader

    @FXML // fx:id="tableColumn_Person"
    private TableColumn<Person, String> tableColumn_Person; // Value injected by FXMLLoader

    @FXML // fx:id="table_Person"
    private TableView<Person> table_Person; // Value injected by FXMLLoader

    @FXML // fx:id="textField_Name"
    private TextField textField_Name; // Value injected by FXMLLoader

    @FXML // fx:id="textField_Age"
    private TextField textField_Age; // Value injected by FXMLLoader
    
    /**
     * List that stores the data that is shown in the table view. 
     */
    private ObservableList<Person> data = FXCollections.observableArrayList(); 

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert button_Add != null : "fx:id=\"button_Add\" was not injected: check your FXML file 'Sample.fxml'.";
        assert button_Remove != null : "fx:id=\"button_Remove\" was not injected: check your FXML file 'Sample.fxml'.";
        assert tableColumn_Age != null : "fx:id=\"tableColumn_Age\" was not injected: check your FXML file 'Sample.fxml'.";
        assert tableColumn_Person != null : "fx:id=\"tableColumn_Person\" was not injected: check your FXML file 'Sample.fxml'.";
        assert table_Person != null : "fx:id=\"table_Person\" was not injected: check your FXML file 'Sample.fxml'.";
        assert textField_Name != null : "fx:id=\"textField_Name\" was not injected: check your FXML file 'Sample.fxml'.";
        assert textField_Age != null : "fx:id=\"textField_Age\" was not injected: check your FXML file 'Sample.fxml'.";

        tableColumn_Person.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumn_Age.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        button_Add.setOnAction(event -> { 
        	String name = textField_Name.getText();
        	String age = textField_Age.getText();
        	if(!name.isBlank() && !age.isBlank()) {
        		int iAge;
        		try {
        			iAge = Integer.parseInt(age);
        		} catch(NumberFormatException e) {
        			System.out.println("No valid age defined.");
        			return;
        		}
        		data.add(new Person(name, iAge));
        		table_Person.setItems(data);
        	}
        });
        
        button_Remove.setOnAction(event -> {
        	Person toRemove = table_Person.getSelectionModel().getSelectedItem();
        	data.remove(toRemove);
        	table_Person.setItems(data);
        });

    }

    /**
     * Gets used to restore the list values that were defined in the latest session. 
     * In this case only default values get used every time the application starts.
     */
	public void reload() {
		data.add(new Person("Bob", 42));
		data.add(new Person("Tim", 21));
		table_Person.setItems(data);
	}

}

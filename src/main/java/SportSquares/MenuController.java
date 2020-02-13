package SportSquares;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * This is used for the menu, the first thing that pops up when you run the code
 * @author MikeBednarski
 *
 */

public class MenuController extends Controller implements Initializable {
	@FXML
	private Button btnRemove;

	@FXML
	private TableView<Person> listOfNames;
	
	@FXML
	private TableColumn<Person, String> Names;
	
	@FXML
	private TableColumn<Person, Integer> Squares;

	@FXML
	private Button btnAdd;

	@FXML
	private Button btnClear;

	@FXML
	private Label squaresLeft;

	@FXML
	private Button btnSubmit;

	@FXML
	private TextField nameBox;
	
	@FXML
	private TextField team1Box;
	
	@FXML
	private TextField team2Box;

	@FXML
	private Spinner<Integer> squaresCount;
	
	private int countOfSquaresLeft = 100;
	
	
	//First thing that is run
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

		squaresCount.setValueFactory(valueFactory);
		squaresLeft.setText("Squares Left: 100");
		
		Names.setCellValueFactory(new PropertyValueFactory<Person, String>("Name"));
		Squares.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Squares"));
		
		
		//We do not want anyone resizing or reordering the columns.
		Names.setResizable(false);
		Names.setReorderable(false);
		Squares.setResizable(false);
		Squares.setReorderable(false);
		
		
	}
	
	
	@FXML
	public void addButtonPressed(ActionEvent event) {
		String name = nameBox.getText();
		if (name.isEmpty()) {
			errorMessage("Name is empty");
			return;
		}
		int squaresChosen = squaresCount.getValue();
		if (squaresChosen > countOfSquaresLeft) {
			errorMessage("Too many squares chosen. Please choose a smaller amount");
			return;
		}
		for(Person per: listOfNames.getItems() ) {
			if (per.getName().equalsIgnoreCase(name)) {
				per.addSquares(squaresChosen);
				listOfNames.refresh();
				countOfSquaresLeft -= squaresChosen;
				squaresLeft.setText("Squares Left : " + countOfSquaresLeft);
				return;
			}
		}
		countOfSquaresLeft -= squaresChosen;
		squaresLeft.setText("Squares Left : " + countOfSquaresLeft);
		Person p = new Person(name, squaresChosen);
		listOfNames.getItems().add(p);
		
	}
	
	@FXML
	public void removeButtonPressed(ActionEvent event) {
		Person selectedItem = listOfNames.getSelectionModel().getSelectedItem();
		if (selectedItem == null) {
			errorMessage("No item selected for removal");
			return;
		}
		countOfSquaresLeft += selectedItem.getSquares();
		squaresLeft.setText("Squares Left : " + countOfSquaresLeft);
		listOfNames.getItems().remove(selectedItem);
		}
	
	@FXML
	public void clearButtonPressed(ActionEvent event) {
		listOfNames.getItems().clear();
		countOfSquaresLeft = 100;
		squaresLeft.setText("Squares Left: 100");

	}
	
	/*
	 * This will display the squares
	 */
	@FXML
	public void submitButtonPressed(ActionEvent event) throws IOException {
		if (countOfSquaresLeft != 0) {
			errorMessage("All squares have not been filled");
			return;
		}
		String t1 = team1Box.getText();
		String t2 = team2Box.getText();
		if (t1.isEmpty() || t2.isEmpty()) {
			errorMessage("Team Box(es) are not filled in");
			return;
		}		
		SquaresController sControl = WindowController.openSquares();
		sControl.placeNames(listOfNames.getItems());
		sControl.setTeamNames(t1, t2);
		countOfSquaresLeft = 100;
		squaresLeft.setText("Squares Left: 100");
		
	}
	/*
	 * Will print out an error Dialog when something goes wrong
	 */
	private void errorMessage(String message) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setContentText(message);
		alert.showAndWait();
	}

	
	
	
}

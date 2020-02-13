package SportSquares;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * This provides the squares
 * 
 * @author MikeBednarski
 *
 */

public class SquaresController extends Controller implements Initializable{

	@FXML
	public GridPane SquaresBoard;
	
	@FXML
	public Button btnPrint;
	
	@FXML
	public Label team1;
	
	@FXML
	public Label team2;
	
	@FXML
	public GridPane mainScreen;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setRandomNumbersUp();
		btnPrint.setDisable(true); //As of 2/13/20, the print button will be disabled
	}
	
	/**
	 * Using two lists, merge them into a list to place in the single digit numbers and place them in one big list.
	 * 
	 */
	void setRandomNumbersUp() {
		Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Integer[] numbers2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> numsList = Arrays.asList(numbers);
		Collections.shuffle(numsList);
		List<Integer> numsList2 = Arrays.asList(numbers2);
		Collections.shuffle(numsList2);
		List<Integer> combinedList = Stream.of(numsList, numsList2).flatMap(Collection::stream).collect(Collectors.toList());
		
		
		int counter = 0;
		for (Node node : SquaresBoard.getChildren()) {
		
			if (node instanceof Label) {
				((Label) node).setText(combinedList.get(counter).toString());
			}
			counter++;
		}
		
	}
	/*
	 * Choose from the list and then place it in. If they have no squares left, remove them from the list.
	 */
	void placeNames(ObservableList<Person> personList) {
		int chosenNumber;
		Random random = new Random();
		for (Node node : SquaresBoard.getChildren()) {
			if (node instanceof TextField) {
				chosenNumber = random.nextInt(personList.size());
				((TextField) node).setText(personList.get(chosenNumber).getName());	
				personList.get(chosenNumber).subtractSquares(1);
				if (personList.get(chosenNumber).getSquares() == 0) {
					personList.remove(chosenNumber);
				}
			}
		}
	}
	
	void setTeamNames(String t1, String t2) {
		team1.setText(t1);
		team2.setText(t2);
	}
	
	/**
	 * @apiNote This function is not ready since there are some problems with printing the panel. 
	 * Hopefully this can be resolved in a later release.
	 */
	@FXML
	public void print(ActionEvent ae) {
		//Window test = ((Node)ae.getTarget()).getScene().getWindow();

	}
	

	

}

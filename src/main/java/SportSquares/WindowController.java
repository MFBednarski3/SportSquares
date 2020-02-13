package SportSquares;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This controls the different windows and to save code.
 * 
 * @author MikeBednarski
 *
 */

public class WindowController {

	private static Controller openNewWindow(String layout, String title) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(ExecuteClass.class.getResource(layout));
		Parent root = fxmlLoader.load();
		Controller ctrl = fxmlLoader.getController();
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		ctrl.setCurrentStage(stage);
		stage.show();
		return ctrl;
	}

	public static MenuController openMenu() throws IOException {
		return (MenuController) openNewWindow("Menu.fxml", "Main Menu");
	}

	public static SquaresController openSquares() throws IOException {
		return (SquaresController) openNewWindow("Squares.fxml", "Squares");
	}


}

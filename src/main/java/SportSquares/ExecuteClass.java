package SportSquares;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class calls up the Menu and starts the program.
 * 
 * @author MikeBednarski
 * 
 */

public class ExecuteClass extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		WindowController.openMenu();
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

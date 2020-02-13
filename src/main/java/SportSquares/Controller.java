package SportSquares;

import javafx.stage.Stage;

/**
 * Because we need access to two different windows. I need to use a "dummy" class which can associate the controllers together.
 * 
 * The methods below are just for design purpose.
 * @author MikeBednarski
 *
 */

public class Controller {
    private Stage currentStage;

    void setCurrentStage(Stage currentStage) {
        this.currentStage = currentStage;
    }
    
    Stage getCurrentStage() {
    	return currentStage;
    }
}

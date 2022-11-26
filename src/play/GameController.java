package play;

import interfaces.InteractionInterface;
import model.GameInstance;
import model.StructureImplementationType;
import validations.Validator;

public class GameController {

    private static GameController instance;
    private InteractionInterface interactionInterface;

    private GameController() {
        this.interactionInterface = InteractionInterface.getInstance();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void play() {

    }

    public void startGame(String[] args) {
        Validator.getInstance().validateArguments(args);
        GameInstance gameInstance = new GameInstance(StructureImplementationType.toEnum(args[0]), Short.valueOf(args[1]));
        gameInstance.showTowers();
    }
}

package play;

import interfaces.InteractionInterface;

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

    public void startGame() {
        short quantityOfTowers = this.interactionInterface.getQuantityOfTowers();

    }

}

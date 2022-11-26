package controller;

import interfaces.InteractionInterface;
import model.GameInstance;
import model.StructureImplementationType;
import validations.Validator;

public class GameController {

    private static GameController instance;
    private final Validator validator;
    private InteractionInterface interactionInterface;

    private GameController() {
        this.interactionInterface = InteractionInterface.getInstance();
        this.validator = Validator.getInstance();
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void play(GameInstance gameInstance) {
        short originTower = getOriginTower(gameInstance);
        short destinationTower = getDestinationTower();
        if (!this.validator.validateValidateMove(gameInstance, originTower, destinationTower)) {
            this.play(gameInstance);
        }
        gameInstance.play(originTower, destinationTower);
        gameInstance.showTowers();
        if (!gameInstance.isFinish()) {
            this.play(gameInstance);
        } else {
            this.interactionInterface.showFinishMessage(gameInstance.getNumberOfMoves());
        }
    }

    private short getOriginTower(GameInstance gameInstance) {
        short originTower = (short) (this.interactionInterface.getOriginTower() - 1);
        if (!this.validator.validateNumberOfTower(originTower) || !this.validator.validateOriginTower(gameInstance, originTower)) {
            return getOriginTower(gameInstance);
        }
        return originTower;
    }

    private short getDestinationTower() {
        short originTower = (short) (this.interactionInterface.getDestinationTower() - 1);
        if (!this.validator.validateNumberOfTower(originTower)) {
            return getDestinationTower();
        }
        return originTower;
    }

    public void startGame(String[] args) {
        Validator.getInstance().validateArguments(args);
        GameInstance gameInstance = new GameInstance(StructureImplementationType.toEnum(args[0]), args.length > 1 ? Short.valueOf(args[1]) : null);
        gameInstance.showTowers();
        this.play(gameInstance);
    }
}

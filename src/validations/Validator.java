package validations;

import interfaces.InteractionInterface;
import model.GameInstance;
import model.StructureImplementationType;

public class Validator {
    private static Validator instance;

    InteractionInterface interactionInterface;

    private Validator() {
        interactionInterface = InteractionInterface.getInstance();
    }

    public static Validator getInstance() {
        if (instance == null) {
            instance = new Validator();
        }
        return instance;
    }

    public void validateArguments(String[] arguments) {
        if (arguments.length == 0) {
            interactionInterface.informArgument();
        } else {
            this.validateImplementationType(arguments[0]);
            if (arguments.length == 2) {
                this.validateNumberOfRingsArgument(arguments[1]);
            }
        }
    }

    public boolean validateValidateMove(GameInstance game, short from, short to) {
        if (from == to) {
            this.interactionInterface.invalidMoveFromIsEqualToTo();
            return false;
        }
        if (!(game.getTop(to) == null) && game.getTop(from).getSize() > game.getTop(to).getSize()) {
            this.interactionInterface.invalidMoveFromRingIsGreaterThanTo();
            return false;
        }
        return true;
    }

    public boolean validateNumberOfTower(short numberOfTower) {
        if (numberOfTower < 0 || numberOfTower > 2) {
            this.interactionInterface.towerNonexistent();
            return false;
        }
        return true;
    }

    public boolean validateOriginTower(GameInstance game, short numberOfTower) {
        if (game.getTop(numberOfTower) == null) {
            this.interactionInterface.hasNoRing();
            return false;
        }
        return true;
    }

    void validateImplementationType(String implementationType) {
        if (StructureImplementationType.toEnum(implementationType) == null) {
            interactionInterface.invalidImplementationTypeOption();
        }
    }

    void validateNumberOfRingsArgument(String numberOfRingsArgument) {
        try {
            short numberOfRings = Short.parseShort(numberOfRingsArgument);
            if (numberOfRings < 3) {
                this.interactionInterface.invalidSecondArgumentShouldBeGreaterThan3();
            }
        } catch (NumberFormatException e) {
            this.interactionInterface.invalidSecondArgument();
        }
    }
}

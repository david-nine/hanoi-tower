package validations;

import interfaces.InteractionInterface;
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

    void validateImplementationType(String implementationType) {
        if (StructureImplementationType.toEnum(implementationType) == null) {
            interactionInterface.invalidImplementationTypeOption();
        }
    }

    void validateNumberOfRingsArgument(String numberOfRingsArgument) {
        try {
            Short.valueOf(numberOfRingsArgument);
        } catch (NumberFormatException e) {
            this.interactionInterface.invalidSecondArgument();
        }
    }
}

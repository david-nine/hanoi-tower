package interfaces;

import java.util.Scanner;

import static model.StructureImplementationType.CONTIGUOUS;
import static model.StructureImplementationType.DYNAMIC;

public class InteractionInterface {

    private static InteractionInterface instance;
    private Scanner sc;

    private InteractionInterface() {
        this.sc = new Scanner(System.in);
    }

    public static InteractionInterface getInstance() {
        if (instance == null) {
            instance = new InteractionInterface();
        }
        return instance;
    }

    public short getOriginTower() {
        return getShort("De qual torre você quer mexer?: ");
    }

    public short getDestinationTower() {
        return getShort("Para qual torre você quer mexer?: ");
    }

    public void invalidImplementationTypeOption() {
        throw new RuntimeException(String.format("Opção inválida! As opções são %s e %s", //
                DYNAMIC.name(), CONTIGUOUS.name()));
    }

    public void informArgument() {
        throw new RuntimeException("Informe o tipo da implementação da pilha");
    }

    public void invalidSecondArgument() {
        throw new RuntimeException("O segundo argumento deve ser um número");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    private short getShort(String message) {
        System.out.print(message);
        short tower = sc.nextShort();
        sc.close();
        return tower;
    }

}

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
        this.showMessage(String.format("Opção inválida! As opções são %s e %s", //
                DYNAMIC.value, CONTIGUOUS.value));
        throw new RuntimeException();
    }

    public void informArgument() {
        this.showMessage("Informe o tipo da implementação da pilha");
        throw new RuntimeException();
    }

    public void invalidSecondArgument() {
        this.showMessage("O segundo argumento deve ser um número");
        throw new RuntimeException();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    private short getShort(String message) {
        System.out.print(message);
        short tower = sc.nextShort();
        return tower;
    }

    public void invalidMoveFromIsEqualToTo() {
        this.invalidMove();
        this.showMessage("Não é permitido mover para a mesma torre");
    }

    private void invalidMove() {
        this.showMessage("Jogada inválida!");
    }

    public void towerNonexistent() {
        this.showMessage("O número da torre deve ser 1, 2 ou 3");
    }

    public void hasNoRing() {
        this.invalidMove();
        this.showMessage("Não tem nenhum anel nesta torre");
    }

    public void invalidMoveFromRingIsGreaterThanTo() {
        this.invalidMove();
        this.showMessage("Não se pode mover um anel maior em cima de um menor");
    }

    public void showFinishMessage(int numberOfMoves) {
        System.out.println(String.format("Ganhou em %s jogadas", numberOfMoves));
    }

    public void invalidSecondArgumentShouldBeGreaterThan3() {
        this.showMessage("O número de anéis deve ser maior do que 3");
        throw new RuntimeException();
    }
}

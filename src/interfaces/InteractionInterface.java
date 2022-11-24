package interfaces;

import java.util.Scanner;

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

    public short getQuantityOfTowers() {
        return getShort("Com quantas torres quer jogar?: ");
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

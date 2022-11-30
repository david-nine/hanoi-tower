package model;

import interfaces.InteractionInterface;
import datastructures.list.IList;
import datastructures.list.ListBuilder;
import datastructures.pile.IPile;
import datastructures.pile.PileBuilder;

public class GameInstance {

    private static final int DEFAULT_RINGS = 5;
    private static final int NUMBER_OF_TOWERS = 3;
    private InteractionInterface interactionInterface;

    private short numberOfPlays;

    private short numberOfRings;
    private final IList<IPile<Ring>> towers;

    public GameInstance(StructureImplementationType implementationType, Short numberOfRings) {
        this.interactionInterface = InteractionInterface.getInstance();
        this.numberOfRings = numberOfRings == null ? DEFAULT_RINGS : numberOfRings;
        this.towers = ListBuilder.builder()
                .withImplementationType(implementationType)
                .withDefaultSize(numberOfRings)
                .build();
        this.createPiles(implementationType);
        this.createRings();
    }

    private void createPiles(StructureImplementationType structureImplementationType) {
        for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
            this.towers.add(PileBuilder.builder() //
                    .withPileImplementationType(structureImplementationType) //
                    .withNumberOfRegisters(numberOfRings) //
                    .build());
        }
    }

    private void createRings() {
        for (int i = numberOfRings; i > 0; i--) {
            this.towers.get(0).push(new Ring((short) (i + 1)));
        }
    }

    public void play(short from, short to) {
        this.towers.get(to).push(this.towers.get(from).pop());
        this.numberOfPlays++;
    }

    public Ring getTop(short tower) {
        return this.towers.get(tower).top();
    }

    public void showTowers() {
        for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
            this.interactionInterface.showMessage("Torre " + (i + 1));
            String tower = towers.get(i).toString();
            this.interactionInterface.showMessage(this.showTower(tower));
        }
    }

    public boolean isFinish() {
        if (this.towers.get(2).size() == this.numberOfRings) {
            return true;
        }
        return false;
    }

    public int getNumberOfMoves() {
        return this.numberOfPlays;
    }

    private String showTower(String tower) {
        char[] charArray = tower.toCharArray();
        short counter = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '\n') {
                counter++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < numberOfRings - counter; j++) {
            stringBuilder.append(" |\n");
        }
        return stringBuilder.append(tower).toString();
    }
}

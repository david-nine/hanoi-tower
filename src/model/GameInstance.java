package model;

import list.IList;
import list.ListBuilder;
import pile.IPile;
import pile.PileBuilder;

public class GameInstance {

    private short numberOfPlays;

    private short numberOfRings;
    private final IList<IPile<Ring>> towers;

    public GameInstance(StructureImplementationType implementationType, Short numberOfRings) {
        this.numberOfRings = numberOfRings == null ? 3 : numberOfRings;
        this.towers = ListBuilder.builder()
                .withImplementationType(implementationType)
                .withDefaultSpaces(numberOfRings)
                .build();
        this.createRings(implementationType, numberOfRings);
    }

    public void buildTowers(StructureImplementationType structureImplementationType, Short numberOfRings) {
        new GameInstance(structureImplementationType, numberOfRings);
    }

    private void createRings(StructureImplementationType structureImplementationType, short numberOfRings) {
        for (int i = 0; i < numberOfRings; i++) {
            this.towers.add(PileBuilder.builder() //
                    .withPileImplementationType(structureImplementationType) //
                    .withNumberOfRegisters(numberOfRings) //
                    .build() //
            );
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
        for (int i = 0; i < 3; i++) {
            towers.toString();
        }
    }

    public boolean isFinish() {
        if (this.towers.get(2).size() == this.numberOfRings) {
            return true;
        }
        return false;
    }
}

package datastructures.pile;

import model.Ring;
import model.StructureImplementationType;

public class PileBuilder {

    private StructureImplementationType type;
    private short numberOfRegisters;

    private PileBuilder() {
    }

    public static PileBuilder builder() {
        return new PileBuilder();
    }

    public PileBuilder withPileImplementationType(StructureImplementationType type) {
        this.type = type;
        return this;
    }

    public PileBuilder withNumberOfRegisters(short numberOfRegisters) {
        this.numberOfRegisters = numberOfRegisters;
        return this;
    }

    public IPile<Ring> build() {
        if (StructureImplementationType.CONTIGUOUS.equals(this.type)) {
            return new ContiguousPile<>(this.numberOfRegisters);
        } else {
            return new DynamicPile<>();
        }
    }

}

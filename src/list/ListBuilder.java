package list;

import model.Ring;
import model.StructureImplementationType;
import pile.IPile;

public class ListBuilder {

    private StructureImplementationType type;
    private Short numberOfRings;
    private ListBuilder() {
    }

    public static ListBuilder builder() {
        return new ListBuilder();
    }

    public IList<IPile<Ring>> build() {
        if (StructureImplementationType.CONTIGUOUS.equals(this.type)) {
            return new ContiguousArrayListImpl();
        } else {
            return new LinkedListImpl();
        }
    }

    public ListBuilder withImplementationType(StructureImplementationType type) {
        this.type = type;
        return this;
    }

    public ListBuilder withDefaultSpaces(short numberOfRings) {
        this.numberOfRings = numberOfRings;
        return this;
    }
}

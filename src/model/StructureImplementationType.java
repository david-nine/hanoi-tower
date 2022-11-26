package model;

import java.util.Arrays;
import java.util.Objects;

public enum StructureImplementationType {

    DYNAMIC("dinamica"),

    CONTIGUOUS("contigua");

    StructureImplementationType(String name) {
    }

    public static StructureImplementationType toEnum(String name) {
        if (name != null && Arrays.stream(StructureImplementationType.values()) //
                .anyMatch(value -> Objects.equals( //
                        value.toString(), //
                        name.toLowerCase() //
                ))) {
            return StructureImplementationType.valueOf(name.toLowerCase());
        }
        return null;
    }

}

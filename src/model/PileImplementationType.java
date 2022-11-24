package model;

import java.util.Arrays;
import java.util.Objects;

public enum PileImplementationType {

    DYNAMIC("dinamica"),

    CONTIGUOUS("contigua");

    PileImplementationType(String name) {}

    public static PileImplementationType toEnum(String name) {
        if (Arrays.stream(PileImplementationType.values()).anyMatch(value -> Objects.equals(value.toString(), name.toLowerCase()))) {
            return PileImplementationType.valueOf(name.toLowerCase());
        }
        return null;
    }
}

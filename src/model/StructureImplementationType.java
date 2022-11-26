package model;

import java.util.HashMap;
import java.util.Map;

public enum StructureImplementationType {

    DYNAMIC("dinamica"),

    CONTIGUOUS("continua");

    public final String value;

    private static final Map<String, StructureImplementationType> MAP = new HashMap<>();

    static {
        MAP.put("dinamica", StructureImplementationType.DYNAMIC);
        MAP.put("continua", StructureImplementationType.CONTIGUOUS);
    }

    private StructureImplementationType(String value) {
        this.value = value;
    }

    public static StructureImplementationType toEnum(String name) {
        return MAP.get(name);
    }
}

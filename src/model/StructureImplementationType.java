package model;

import java.util.HashMap;
import java.util.Map;

public enum StructureImplementationType {

    DYNAMIC,

    CONTIGUOUS;

    private static final Map<String, StructureImplementationType> MAP = new HashMap<>();

    static {
        MAP.put("dinamica", StructureImplementationType.DYNAMIC);
        MAP.put("continua", StructureImplementationType.CONTIGUOUS);
    }

    private StructureImplementationType() {

    }

    public static StructureImplementationType toEnum(String name) {
        return MAP.get(name);
    }
}

package model;

public class Ring {

    private short size;

    public Ring(short size) {
        this.size = size;
    }

    public short getSize() {
        return this.size;
    }
    // caso for meor, consome da esquerda

    public String getRaw(short maxSize) {
        StringBuilder stringBuilder = new StringBuilder();
        addSpaces(stringBuilder, (short) (maxSize - size));
        stringBuilder.append("<");
        addSpaces(stringBuilder, size);
        stringBuilder.append("|");
        addSpaces(stringBuilder, size);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    private void addSpaces(StringBuilder stringBuilder, short quantity) {
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(" ");
        }
    }
}

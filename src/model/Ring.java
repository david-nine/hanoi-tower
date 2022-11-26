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

    public String getRaw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<|");
        this.addField(stringBuilder, this.size, '-');
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    private void addField(StringBuilder stringBuilder, short quantity, char character) {
        for (int i = 0; i < quantity; i++) {
            stringBuilder.append(character);
        }
    }
}

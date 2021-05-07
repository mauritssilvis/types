package nl.mauritssilvis.types.string;

public class ArrayString implements String {
    private final char[] chars;

    public ArrayString(char[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return chars.length;
    }
}

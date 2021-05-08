package nl.mauritssilvis.types.string;

public class ArrayString implements String {
    private final char[] chars;

    public ArrayString(char[] chars) {
        this.chars = chars.clone();
    }

    public ArrayString(String str) {
        chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(i);
        }
    }

    public ArrayString(java.lang.String str) {
        chars = new char[str.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = str.charAt(i);
        }
    }

    @Override
    public char charAt(int index) {
        return chars[index];
    }

    @Override
    public int length() {
        return chars.length;
    }
}

package be.kdg.TTT.model;

/**
 * Altin Reçica
 * 12/9/2022
 */
public enum Symbol {
    X('X'),O('O'),BLANK(' ');

    Symbol(char asChar) {
        this.asChar = asChar;
    }

    public char asChar() {
        return asChar;
    }

    private final char asChar;

    @Override
    public String toString() {
        return String.valueOf(this.asChar);
    }
}
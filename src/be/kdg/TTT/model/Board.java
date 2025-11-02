package be.kdg.TTT.model;

/**
 * Altin Reçica
 * 12/9/2022
 */
public class Board {

    public static final int RIJEN = 3;
    public static final int KOLOMMEN = 3;

    Symbol[][] field;
    char winner;

    public Board() {
        field = new Symbol[RIJEN][KOLOMMEN];
        for (int i = 0; i < RIJEN; i++) {
            for (int j = 0; j < KOLOMMEN; j++) {
                field[i][j] = Symbol.BLANK;
            }
        }
    }

    public void placeSymbol(int x, int y, Symbol Symbol){
        if (field[x][y] == Symbol.BLANK) {
            field[x][y] = Symbol;
        }
    }

    public void clearBoard(){
        for (int i = 0; i < RIJEN; i++) {
            for (int j = 0; j < KOLOMMEN; j++) {
                field[i][j] = Symbol.BLANK;
            }
        }
    }

    public boolean checkWinner(Symbol Symbol){
        for (int i = 0; i < 3; i++) {
            if (
                    field[i][0] == Symbol &&
                    field[i][1] == Symbol &&
                    field[i][2] == Symbol
            ) {
                winner = Symbol.asChar();
                return true;
            }
            if (
                    field[0][i] == Symbol &&
                    field[1][i] == Symbol &&
                    field[2][i] == Symbol
            ){
                winner = Symbol.asChar();
                return true;
            }
        }

        if (
                field[0][0] == Symbol &&
                field[1][1] == Symbol &&
                field[2][2] == Symbol
        ){
            winner = Symbol.asChar();
            return true;
        }

        if (
                field[0][2] == Symbol &&
                field[1][1] == Symbol &&
                field[2][0] == Symbol
        ){
            winner = Symbol.asChar();
            return true;
        }
        return false;
    }

    public boolean checkPos(int x, int y){
        return field[x][y] == Symbol.BLANK;
    }

    public boolean checkFullBoard(){
        boolean checkTile = false;
        for (int i = 0; i < RIJEN; i++) {
            for (int j = 0; j < KOLOMMEN; j++) {
                if (field[i][j] == Symbol.BLANK) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(){
        System.out.println("  1  2  3");
        for (int i = 0; i < RIJEN; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < KOLOMMEN; j++) {
                System.out.print("|" + field[i][j].asChar() + "|");
            }
            System.out.println();
        }
    }

    public Symbol[][] getBoard(){
        return field;
    }
}

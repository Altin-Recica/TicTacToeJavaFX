package be.kdg.TTT.model;

/**
 * Altin Reçica
 * 12/19/2022
 */
public class ComputerAI {
    private Board board;

    public static int[] findBestMove(Board board) {
        int bestVal = -1;
        int[] bestMove = new int[2];
        bestMove[0] = -1;
        bestMove[1] = -1;
        Symbol[][] field = board.field;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == Symbol.BLANK) {
                    field[i][j] = Symbol.O;

                    int moveVal = minmax(board, field, 0, false);
                    field[i][j] = Symbol.BLANK;

                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        return bestMove;
    }
    public static int minmax(Board board, Symbol field[][], int moves, Boolean isComputer) {
        int score = evaluate(board);

        if (score == 10) {
            return score;
        }else if (score == -10) {
            return score;
        }else if (!board.checkFullBoard()) {
            return 0;
        }

        if (isComputer) {
            int best = -10;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == Symbol.BLANK) {
                        field[i][j] = Symbol.O;
                        best = Math.max(best, minmax(board, field, moves + 1, false));
                        field[i][j] = Symbol.BLANK;
                    }
                }
            }
            return best;
        }
        else {
            int best = 10;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == Symbol.BLANK) {
                        field[i][j] = Symbol.X;
                        best = Math.min(best, minmax(board, field, moves + 1, true));
                        field[i][j] = Symbol.BLANK;
                    }
                }
            }
            return best;
        }
    }
    private static int evaluate(Board board) {
        if (board.checkWinner(Symbol.O)) {
            return 10;
        } else if (board.checkWinner(Symbol.X)) {
            return -10;
        } else {
            return 0;
        }
    }
}

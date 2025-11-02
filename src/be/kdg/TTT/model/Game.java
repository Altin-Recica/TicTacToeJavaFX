package be.kdg.TTT.model;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Altin Reçica
 * 12/9/2022
 */
public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    public boolean firstPlayerTurn;

    LocalDateTime  timeStart;
    LocalDateTime  timeStop;

    public Game(Board board, Player player1, Player player2, boolean firstPlayerTurn) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.firstPlayerTurn = firstPlayerTurn;
    }

    public void start(){
        timeStart = LocalDateTime.now();
    }

    public void stop(){
        timeStop = LocalDateTime.now();
    }

    public long calculateLength(){
        return Duration.between(timeStart, timeStop).toSeconds();
    }
}

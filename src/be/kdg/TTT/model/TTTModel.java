package be.kdg.TTT.model;

import be.kdg.TTT.view.game.Presenter;
import be.kdg.TTT.view.game.TTTView;
import be.kdg.TTT.view.gamemode.ModePresenter;
import be.kdg.TTT.view.gamemode.ModeView;
import be.kdg.TTT.view.mainpage.MainPageView;
import be.kdg.TTT.view.playername.NamePresenter;
import be.kdg.TTT.view.playername.NameView;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.text.View;
import java.awt.event.HierarchyBoundsAdapter;
import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class TTTModel {

    private LeaderboardFileManager lbFileManager;
    private Symbol turn;
    private boolean finished;
    private Board board;
    private Game game;
    private Player player1;
    private Player player2;
    private Boolean mode;

    private Boolean turnChecker;

    private Player winner;

    private int counter;

    private int p1Score;
    private int p2Score;

    private int tieScore;

    public TTTModel() {
        lbFileManager = new LeaderboardFileManager();

        turn = Symbol.X;
        turnChecker = true;
        p1Score = 0;
        p2Score = 0;
        tieScore = 0;
        reset();
    }

    public void reset() {
        counter = 0;
        board = new Board();
        finished = false;

    }

    public void placeSymbol(int rij, int kolom) {
        counter++;
        board.placeSymbol(rij, kolom, turn);
        if (turnChecker) {
            turn = Symbol.O;
            winner = player1;
            turnChecker = false;
        } else {
            turn = Symbol.X;
            winner = player2;
            turnChecker = true;
        }
    }

    public void write() {
        lbFileManager.writeToFile(winner, player1, player2, p1Score, p2Score, tieScore);
    }

    public List<String> read() {
        return lbFileManager.readFile();
    }

    public void start(Board board, Game game, Player player1, Player player2) {
        this.board = board;
        this.game = game;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void chooseMode(Boolean mode) {
        this.mode = mode;
    }

    public boolean gameFinished() {
        return board.checkWinner(Symbol.X) || board.checkWinner(Symbol.O);
    }

    public boolean getMode() {
        return mode;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public String getWinnerName() {
        return winner.getName();
    }

    public Boolean getWinnar() {
        if (winner == player1) {
            return true;
        } else {
            return false;
        }
    }

    public Board getBoard() {
        return board;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public int getTieScore() {
        return tieScore;
    }

    public void setTieScore(int tieScore) {
        this.tieScore = tieScore;
    }

    public Boolean getTurnChecker() {
        return turnChecker;
    }

    public void setTurnChecker(Boolean turnChecker) {
        this.turnChecker = turnChecker;
    }

    public int getCounter() {
        return counter;
    }

    public void changeTurn() {
        turnChecker = !turnChecker;
    }

    public Symbol getTurn() {
        return turn;
    }

    public void setTurn(Symbol turn) {
        this.turn = turn;
    }


}
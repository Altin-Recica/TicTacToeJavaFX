package be.kdg.TTT.view.game;

import be.kdg.TTT.model.*;
import be.kdg.TTT.view.gamemode.ModePresenter;
import be.kdg.TTT.view.gamemode.ModeView;
import be.kdg.TTT.view.mainpage.MainPagePresenter;
import be.kdg.TTT.view.mainpage.MainPageView;
import be.kdg.TTT.view.playername.NamePresenter;
import be.kdg.TTT.view.playername.NameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.IllegalFormatCodePointException;
import java.util.Optional;
import java.util.Random;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class Presenter {
    private TTTModel model;
    private TTTView view;

    private NamePresenter namePresenter;

    private int scoreP1;
    private int scoreP2;
    private Random random;


    public Presenter(TTTModel model, TTTView view) {
        random = new Random();
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getMenu().setOnAction(actionEvent -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("This game was made by Altin and Stef");
            alert.setContentText("Students from KdG University Antwerp");
            alert.showAndWait();
        }
        );


        Button buttons[][] = view.getButton();
        for (int i = 0; i < TTTView.RIJEN; i++){
            for (int j = 0; j < TTTView.KOLOMMEN; j++){
                int rij = i;
                int kolom = j;
                buttons[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (!model.getMode()) {
                            if (model.getBoard().checkPos(rij, kolom)) {
                                model.placeSymbol(rij, kolom);
                                model.getBoard().draw();
                                updateView();
                            } else {
                                invalidPlacement();
                            }
                        }else{
                            model.setTurnChecker(true);
                            if (model.getBoard().checkPos(rij, kolom)) {
                                model.placeSymbol(rij, kolom);
                                model.getBoard().draw();
                                updateView();

                                if (model.getCounter() >= 9) {
                                    //game board full
                                    if (model.getTurn() == Symbol.X) {
                                        model.setTurn(Symbol.O);
                                    }else{
                                        model.setTurn(Symbol.X);
                                    }

                                    model.setTurnChecker(!model.getTurnChecker());
                                }else{
                                    model.setTurnChecker(false);
                                    Board minimaxBoard = new Board();
                                    minimaxBoard = model.getBoard();
                                    int[] bestMove = ComputerAI.findBestMove(minimaxBoard);
                                    if (model.getBoard().checkPos(bestMove[0], bestMove[1])) {
                                        model.placeSymbol(bestMove[0], bestMove[1]);
                                        model.getBoard().draw();

                                        updateView();
                                    } else {
                                        invalidPlacement();
                                    }
                                }

                            } else {
                                invalidPlacement();
                            }
                        }

                        if (model.gameFinished() || model.getCounter() >= 9) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            if (model.gameFinished()) {
                                if (model.getWinnar()) {
                                    model.setP1Score(model.getP1Score() + 1);
                                    view.getLblPlayer1().setText("Player 1:\n      " + model.getP1Score());
                                } else {
                                    model.setP2Score(model.getP2Score() + 1);
                                    view.getLblPlayer2().setText("Player 2:\n          " + model.getP2Score());
                                }
                                alert.setTitle("The game is finished!");
                                alert.setHeaderText("De winnaar is: " + model.getWinnerName());
                                alert.setContentText("The game data has been saved!");
                            } else if (model.getCounter() >= 9) {
                                model.setTieScore(model.getTieScore() + 1);
                                view.getLblTie().setText("  Tie:\n    " + model.getTieScore());
                                alert.setTitle("The game is finished!");
                                alert.setHeaderText("The game was a draw!");
                                alert.setContentText("The game data has been saved!");
                            }
                            ButtonType again = new ButtonType("Again");
                            ButtonType returnHome = new ButtonType("Return Home");
                            alert.getButtonTypes().clear();
                            alert.getButtonTypes().addAll(again, returnHome);
                            Optional<ButtonType> option = alert.showAndWait();
                            model.changeTurn();
                            if (option.get() == again) {
                                model.reset();
                                model.setTurnChecker(!model.getTurnChecker());
                                for (Button[] buttons2 : buttons) {
                                    for (Button button : buttons2) {
                                        button.setText("");
                                    }
                                }
                            } else if (option.get() == returnHome) {
                                NamePresenter.getGame().stop();
                                model.write();
                                model.reset();
                                model.setP1Score(0);
                                model.setTieScore(0);
                                model.setP2Score(0);
                                model.setTurnChecker(!model.getTurnChecker());
                                MainPageView mainPageView = new MainPageView();
                                MainPagePresenter mainPagePresenter =
                                        new MainPagePresenter(mainPageView, model);

                                Stage stage = new Stage();

                                stage.initOwner(view.getScene().getWindow());
                                stage.initModality(Modality.APPLICATION_MODAL);
                                stage.setScene(new Scene(mainPageView));
                                stage.centerOnScreen();
                                stage.setResizable(false);
                                stage.setWidth(800);
                                stage.setHeight(700);
                                view.getScene().getWindow().hide();
                                stage.show();
                            } else {
                                System.out.println("Please select the following options");
                            }
                        }

                    }
                });
            }
        }
    }

    private void invalidPlacement() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Can't place there!");
        alert.setHeaderText("A player has already placed there!");
        alert.showAndWait();
    }


    private void updateView() {
        Symbol[][] symbols = model.getBoard().getBoard();
        Button[][] buttons = view.getButton();
        for (int i = 0; i < TTTView.RIJEN; i++){
            for (int j = 0; j < TTTView.KOLOMMEN; j++){
                buttons[i][j].setText(symbols[i][j].toString());
            }
        }
    }

    public void closewindowEvent(){
        view.getScene().getWindow().setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Your game is about to close!");
            alert.setContentText("Are you sure?");
            alert.setTitle("Warning all your data will be lost!");
            alert.getButtonTypes().clear();
            ButtonType no = new ButtonType("No");
            ButtonType yes = new ButtonType("Yes");
            alert.getButtonTypes().addAll(no, yes);
            alert.showAndWait();
            if (alert.getResult() == null || alert.getResult().equals(no)) {
                event.consume();
            }
        });
    }


}

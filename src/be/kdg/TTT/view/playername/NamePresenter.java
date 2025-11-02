package be.kdg.TTT.view.playername;

import be.kdg.TTT.model.*;
import be.kdg.TTT.view.game.Presenter;
import be.kdg.TTT.view.game.TTTView;
import be.kdg.TTT.view.gamemode.ModePresenter;
import be.kdg.TTT.view.gamemode.ModeView;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Altin Reçica
 * 2/15/2023
 */
public class NamePresenter {

    private NameView view;
    private TTTModel model;
    Player player1;
    Player player2;

    static Game game;

    Board board;

    public NamePresenter(NameView view, TTTModel model) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {

        view.getBtnStart().setOnAction(actionEvent -> {
            if (view.getTxtP1().getText().isEmpty() || view.getTxtP2().getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Empty field!");
                alert.setHeaderText("You must choose a name!");
                alert.showAndWait();
            }else{
                board = new Board();
                board.draw();
                player1 = new Player(view.getTxtP1().getText(), Symbol.X);
                player2 = new Player(view.getTxtP2().getText(), Symbol.O);
                game = new Game(board, player1, player2, true);
                game.start();

                model.start(board, game, player1, player2);

                TTTView modeView = new TTTView();
                Presenter tttPresenter = new Presenter(model, modeView);
                Stage stage = new Stage();
                stage.initOwner(view.getScene().getWindow());
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(modeView));
                stage.centerOnScreen();
                stage.setResizable(false);
                view.getScene().getWindow().hide();
                tttPresenter.closewindowEvent();
                stage.show();
            }
        });
    }
    private void updateView() {
    }


    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public static Game getGame() {
        return game;
    }

    public Board getBoard() {
        return board;
    }
}

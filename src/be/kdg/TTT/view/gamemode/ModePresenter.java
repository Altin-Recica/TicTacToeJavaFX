package be.kdg.TTT.view.gamemode;

import be.kdg.TTT.model.TTTModel;
import be.kdg.TTT.view.game.Presenter;
import be.kdg.TTT.view.game.TTTView;
import be.kdg.TTT.view.playername.NamePresenter;
import be.kdg.TTT.view.playername.NameView;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class ModePresenter {
    private TTTModel model;
    private ModeView view;


    public ModePresenter(TTTModel model, ModeView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void updateView() {

    }

    private void addEventHandlers() {
        view.getBtnPlayer2().setOnAction(actionEvent -> {
            model.chooseMode(false);
            NameView nameView = new NameView();
            nameView.getLblP2().setText("Player 2 name: ");
            NamePresenter Presenter =
                    new NamePresenter(nameView, model);

            Stage stage = new Stage();

            stage.initOwner(view.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(nameView));
            stage.centerOnScreen();
            stage.setResizable(false);
            view.getScene().getWindow().hide();
            stage.show();
        });
        model.chooseMode(true);
        view.getBtnComputer().setOnAction(actionEvent -> {
            NameView nameView = new NameView();
            nameView.getLblP2().setText("Computer name: ");
            NamePresenter Presenter =
                    new NamePresenter(nameView, model);

            Stage stage = new Stage();

            stage.initOwner(view.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(nameView));
            stage.centerOnScreen();
            stage.setResizable(false);
            view.getScene().getWindow().hide();
            stage.show();
        });
    }
}

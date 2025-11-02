package be.kdg.TTT.view.mainpage;

import be.kdg.TTT.model.TTTModel;
import be.kdg.TTT.view.game.Presenter;
import be.kdg.TTT.view.game.TTTView;
import be.kdg.TTT.view.gamemode.ModePresenter;
import be.kdg.TTT.view.gamemode.ModeView;
import be.kdg.TTT.view.leaderboards.LBPresenter;
import be.kdg.TTT.view.leaderboards.LBView;
import be.kdg.TTT.view.playername.NamePresenter;
import be.kdg.TTT.view.playername.NameView;
import com.sun.webkit.Timer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class MainPagePresenter {
    private MainPageView mpView;
    private TTTModel model;

    public MainPagePresenter(MainPageView mpView, TTTModel model) {
        this.mpView = mpView;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // Platform.exit();

        mpView.getBtnPlay().setOnAction(actionEvent -> {
            ModeView modeView = new ModeView();
            ModePresenter modePresenter =
                    new ModePresenter(model, modeView);

            Stage stage = new Stage();

            stage.initOwner(mpView.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(modeView));
            stage.centerOnScreen();
            stage.setResizable(false);
            mpView.getScene().getWindow().hide();
            stage.show();
        });

        mpView.getBtnLeaderboard().setOnAction(actionEvent -> {
            LBView lbView = new LBView();
            LBPresenter lbPresenter =
                    new LBPresenter(model, lbView);

            Stage stage = new Stage();

            stage.initOwner(mpView.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(lbView));
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setWidth(800);
            stage.setHeight(700);
            mpView.getScene().getWindow().hide();
            stage.show();
        });

        mpView.getBtnQuit().setOnAction(actionEvent -> {
            Platform.exit();
        });
    }

    private void updateView() {

    }
}

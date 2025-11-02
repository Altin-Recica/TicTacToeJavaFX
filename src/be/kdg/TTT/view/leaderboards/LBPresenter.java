package be.kdg.TTT.view.leaderboards;

import be.kdg.TTT.model.TTTModel;
import be.kdg.TTT.view.gamemode.ModePresenter;
import be.kdg.TTT.view.gamemode.ModeView;
import be.kdg.TTT.view.mainpage.MainPagePresenter;
import be.kdg.TTT.view.mainpage.MainPageView;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Altin Reçica
 * 3/13/2023
 */
public class LBPresenter {

    private TTTModel model;
    private LBView view;

    public LBPresenter(TTTModel model, LBView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    public LBPresenter() {


    }

    private void addEventHandlers() {
        view.getQuitBtn().setOnAction(actionEvent -> {
            Platform.exit();
        });

        view.getBackBtn().setOnAction(actionEvent -> {
            MainPageView mpView = new MainPageView();
            MainPagePresenter mainPagePresenter =
                    new MainPagePresenter(mpView, model);

            Stage stage = new Stage();

            stage.initOwner(view.getScene().getWindow());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(mpView));
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.setWidth(800);
            stage.setHeight(700);
            view.getScene().getWindow().hide();
            stage.show();
        });
    }

    private void updateView() {
        for (String row:model.read()) {
            view.getListView().getItems().add(row);
        }
    }
}

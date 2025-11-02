package be.kdg.TTT;

import be.kdg.TTT.model.Board;
import be.kdg.TTT.model.TTTModel;
import be.kdg.TTT.view.mainpage.MainPagePresenter;
import be.kdg.TTT.view.mainpage.MainPageView;
import be.kdg.TTT.view.game.Presenter;
import be.kdg.TTT.view.game.TTTView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class MainTTT extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        MainPageView mpView = new MainPageView();
        Scene scene = new Scene(mpView);
        TTTModel model = new TTTModel();
        MainPagePresenter mpPresenter = new MainPagePresenter(mpView, model);
        stage.setWidth(800);
        stage.setHeight(700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

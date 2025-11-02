package be.kdg.TTT.view.mainpage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class MainPageView extends VBox {
    private Label lblTic;
    private Label lblTac;
    private Label lblToe;

    private Button btnPlay;
    private Button btnLeaderboard;
    private Button btnQuit;

    public MainPageView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblTic = new Label("Tic");
        lblTac = new Label("Tac");
        lblToe = new Label("Toe");
        btnPlay = new Button("Play");
        btnLeaderboard = new Button("Leaderboard");
        btnQuit = new Button("Quit");
    }

    private void layoutNodes() {
        BackgroundImage backgroundImage;
        try {
            backgroundImage = new BackgroundImage(new Image(new FileInputStream("background.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Background background = new Background(backgroundImage);
        setBackground(background);
        lblTic.setStyle("-fx-font-size:40");
        lblTac.setStyle("-fx-font-size:40");
        lblToe.setStyle("-fx-font-size:40");
        lblTic.setTextFill(Color.WHITE);
        lblTac.setTextFill(Color.WHITE);
        lblToe.setTextFill(Color.WHITE);
        lblTic.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        btnPlay.setPrefWidth(300);
        btnPlay.setStyle("-fx-background-radius: 30px; -fx-font-size: 40; -fx-background-color: white; -fx-font: 30px Verdana; -fx-font-weight: bold;");
        btnLeaderboard.setPrefWidth(300);
        btnLeaderboard.setStyle("-fx-background-radius: 30px; -fx-font-size: 40; -fx-background-color: white; -fx-font: 30px Verdana; -fx-font-weight: bold;");
        btnQuit.setPrefWidth(300);
        btnQuit.setStyle("-fx-background-radius: 30px; -fx-font-size: 40; -fx-background-color: white; -fx-font: 30px Verdana; -fx-font-weight: bold;");
        btnQuit.setTextFill(Color.rgb(29,30,61));
        btnPlay.setTextFill(Color.rgb(29,30,61));
        btnLeaderboard.setTextFill(Color.rgb(29,30,61));

        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        setMargin(lblTic, new Insets(0, 10, 0, 10));
        setMargin(lblTac, new Insets(0, 10, 0, 10));
        setMargin(lblToe, new Insets(0, 10, 100, 10));
        setMargin(btnPlay, new Insets(10));
        setMargin(btnLeaderboard, new Insets(10));
        setMargin(btnQuit, new Insets(10));
        getChildren().add(lblTic);
        getChildren().add(lblTac);
        getChildren().add(lblToe);
        getChildren().add(btnPlay);
        getChildren().add(btnLeaderboard);
        getChildren().add(btnQuit);
    }



    Button getBtnPlay() {
        return btnPlay;
    }

    public Button getBtnQuit() {
        return btnQuit;
    }

    public Button getBtnLeaderboard() {
        return btnLeaderboard;
    }
}

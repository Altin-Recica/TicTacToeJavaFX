package be.kdg.TTT.view.leaderboards;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Altin Reçica
 * 3/13/2023
 */
public class LBView extends BorderPane {
    private Label lblLB;

    private ListView<String> listView;
    private Button quitBtn;
    private Button backBtn;

    public LBView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        lblLB = new Label("Leaderboard");
        listView = new ListView<String>();
        backBtn = new Button("Back");
        quitBtn = new Button("Quit");
    }

    private void layoutNodes() {
        setAlignment(lblLB, Pos.CENTER);
        setMargin(lblLB, new Insets(10));
        lblLB.setStyle("-fx-font-size: 40;");
        setTop(lblLB);
        listView.setStyle("-fx-font-size: 20; -fx-background-color: #F4F4F4;");
        setCenter(listView);
        HBox hBox = new HBox();
        backBtn.setStyle("-fx-background-radius: 10px; -fx-font-size: 40;");
        quitBtn.setStyle("-fx-background-radius: 10px; -fx-font-size: 40;");
        hBox.setSpacing(10);
        setAlignment(hBox, Pos.CENTER);
        hBox.setAlignment(Pos.CENTER);
        setMargin(hBox, new Insets(10));
        hBox.getChildren().addAll(backBtn, quitBtn);
        setBottom(hBox);

    }

    public Button getQuitBtn() {
        return quitBtn;
    }

    public Button getBackBtn() {
        return backBtn;
    }

    public ListView<String> getListView() {
        return listView;
    }
}

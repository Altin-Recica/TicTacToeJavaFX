package be.kdg.TTT.view.gamemode;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class ModeView extends VBox {

    private Label lblTitle;
    private Button btnPlayer2;
    private Button btnComputer;

    public ModeView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        lblTitle = new Label("Choose Mode");
        btnPlayer2 = new Button("     vs\nPlayer 2");
        btnComputer = new Button("       vs\nComputer");
    }
    private void layoutNodes() {
        setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61), CornerRadii.EMPTY, Insets.EMPTY)));
        getChildren().add(lblTitle);
        setAlignment(Pos.CENTER);
        lblTitle.setPadding(new Insets(100));
        lblTitle.setTextFill(Color.WHITE);
        lblTitle.setStyle("-fx-font-size: 60;");

        HBox buttons = new HBox();
        HBox.setHgrow(btnPlayer2, Priority.ALWAYS);
        HBox.setHgrow(btnComputer, Priority.ALWAYS);

        btnComputer.setPadding(new Insets(90));
        btnPlayer2.setPadding(new Insets(90));
        setMargin(btnComputer, new Insets(10));
        setMargin(btnPlayer2, new Insets(10));
        btnComputer.setStyle("-fx-font-size:50; -fx-border-color: white;");
        btnPlayer2.setStyle("-fx-font-size:50; -fx-border-color: white;");

        btnPlayer2.setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61, 0.50), CornerRadii.EMPTY, Insets.EMPTY)));
        btnComputer.setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61, 0.50), CornerRadii.EMPTY, Insets.EMPTY)));
        btnPlayer2.setTextFill(Color.WHITE);
        btnComputer.setTextFill(Color.WHITE);

        buttons.getChildren().addAll(btnPlayer2, btnComputer);
        getChildren().add(buttons);
    }

    Button getBtnPlayer2() {
        return btnPlayer2;
    }

    Button getBtnComputer() {
        return btnComputer;
    }



}

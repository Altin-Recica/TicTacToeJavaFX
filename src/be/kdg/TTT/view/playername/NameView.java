package be.kdg.TTT.view.playername;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Altin Reçica
 * 2/15/2023
 */
public class NameView extends BorderPane {
    private Label lblChoose;
    private Label lblP1;
    private Label lblP2;
    private TextField txtP1;
    private TextField txtP2;
    private Button btnStart;

    public NameView() {
        initialiseNodes();
        layoutNodes();
    }
    private void initialiseNodes() {
        lblChoose = new Label("Choose Name");
        lblP1 = new Label("Player 1 name: ");
        txtP1 = new TextField();
        lblP2 = new Label("Player 2 name: ");
        txtP2 = new TextField();
        btnStart = new Button("Start");
    }
    private void layoutNodes() {
        setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61), CornerRadii.EMPTY, Insets.EMPTY)));
        lblChoose.setTextFill(Color.WHITE);
        setMargin(lblChoose, new Insets(20,0,0,0));
        lblP1.setTextFill(Color.WHITE);
        lblP2.setTextFill(Color.WHITE);

        btnStart.setPrefWidth(300);
        btnStart.setStyle("-fx-background-radius: 10px; -fx-font-size: 40; -fx-background-color: white; -fx-font: 30px Verdana; -fx-font-weight: bold;");
        btnStart.setTextFill(Color.rgb(29,30,61));

        setTop(lblChoose);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(lblP1, txtP1);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(lblP2, txtP2);

        setLeft(vBox1);
        setRight(vBox2);
        setBottom(btnStart);

        setAlignment(lblChoose, Pos.CENTER);
        setAlignment(btnStart, Pos.CENTER);

        vBox1.setPadding(new Insets(100, 50, 50, 50));
        vBox2.setPadding(new Insets(100, 50, 100, 50));


        lblChoose.setStyle("-fx-font-size: 60;");
        lblP1.setStyle("-fx-font-size: 20;");
        lblP2.setStyle("-fx-font-size: 20;");
        txtP1.setStyle("-fx-font-size: 20;");
        txtP2.setStyle("-fx-font-size: 20;");
        btnStart.setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61, 0.50), CornerRadii.EMPTY, Insets.EMPTY)));
        btnStart.setPadding(new Insets(0, 60, 0, 60));
        setMargin(btnStart, new Insets(0, 0, 40, 0));
    }

    public Label getLblP2() {
        return lblP2;
    }

    public TextField getTxtP1() {
        return txtP1;
    }

    public TextField getTxtP2() {
        return txtP2;
    }

    public Button getBtnStart() {
        return btnStart;
    }
}

package be.kdg.TTT.view.game;

import be.kdg.TTT.view.playername.NameView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Altin Reçica
 * 2/8/2023
 */
public class TTTView extends BorderPane {

    static final int RIJEN = 3;
    static final int KOLOMMEN = 3;
    private Button[][] button;
    private MenuBar menuBar;

    private Menu menu;
    private Label lblPlayer1;
    private Label lblTie;
    private Label lblPlayer2;
    private NameView nameView = new NameView();

    public TTTView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        menuBar = new MenuBar();
        menu = new Menu("Options");
        button = new Button[RIJEN][KOLOMMEN];
        lblPlayer1 = new Label("Player 1:\n      0");
        lblTie = new Label("  Tie:\n    0");
        lblPlayer2 = new Label("Player 2:\n          0");
    }

    private void layoutNodes() {
        setBackground(new Background(new BackgroundFill(Color.rgb(29,30,61), CornerRadii.EMPTY, Insets.EMPTY)));
        MenuItem about = new MenuItem("About");
        menu.getItems().add(about);
        menuBar.getMenus().add(menu);
        BackgroundImage backgroundImage;
        GridPane gPane = new GridPane();
        HBox hBox = new HBox(3);
        hBox.setPadding(new Insets(5, 0, 0, 0));

        for (int i = 0; i < RIJEN; i++) {
            for (int j = 0; j < KOLOMMEN; j++) {
                button[i][j] = new Button("...");
                button[i][j].setPrefSize(100, 100);
                button[i][j].setStyle("-fx-font-size:40; -fx-border-style: solid ; -fx-border-width: 1; -fx-border-color: white;");
                button[i][j].setBackground(null);
                button[i][j].setTextFill(Color.WHITE);
                gPane.add(button[i][j], j, i); // Eerst kolom dan rij
                GridPane.setHgrow(button[i][j], Priority.ALWAYS);
                GridPane.setVgrow(button[i][j], Priority.ALWAYS);
            }
        }
        setCenter(gPane);

        lblPlayer1.setStyle("-fx-font-size:15;");
        lblTie.setStyle("-fx-font-size:15");
        lblPlayer2.setStyle("-fx-font-size:15");

        lblPlayer1.setTextFill(Color.WHITE);
        lblTie.setTextFill(Color.WHITE);
        lblPlayer2.setTextFill(Color.WHITE);

        hBox.getChildren().addAll(lblPlayer1, lblTie, lblPlayer2);
        hBox.setSpacing(50);
        hBox.setPadding(new Insets(0, 0, 0, 20));

        setTop(menuBar);
        setCenter(gPane);
        setBottom(hBox);




    }

    public Label getLblPlayer2() {
        return lblPlayer2;
    }

    public Label getLblPlayer1() {
        return lblPlayer1;
    }

    public Label getLblTie() {
        return lblTie;
    }

    public Button[][] getButton() {
        return button;
    }

    public Menu getMenu() {
        return menu;
    }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import provided.Difficulty;
import provided.MinesweeperGame;
import provided.Tile;

/**
 * @author akwok6
 * @version 1.0
 */

public class MinesweeperView extends Application {
    /**
     * Sets the start screen for the game. Includes a welcome message, difficulty selector,
     * name box, and a start button.
     * @param primaryStage a stage object that is to be shown to the user
     */
    @Override
    public void start(Stage primaryStage) {

        Label greeting = new Label("Welcome to Minesweeper!");
        greeting.setFont(new Font("Courier New", 35));

        TextField textField = new TextField();
        textField.setPromptText("Enter name");
        textField.setPrefWidth(150);
        textField.setMaxWidth(150);

        ComboBox<Difficulty> comboBox = new ComboBox<>();
        comboBox.setPromptText("Select difficulty");
        ObservableList<Difficulty> list = comboBox.getItems();
        list.add(Difficulty.EASY);
        list.add(Difficulty.MEDIUM);
        list.add(Difficulty.HARD);

        Button button = new Button("Start");
        button.setOnAction(e -> {
            if (!(textField.getText().isEmpty()) && !(comboBox.getValue() == null)) {
                playMinesweeper(primaryStage, comboBox.getValue(), textField.getText());
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setContentText("Invalid inputs. Please select a difficulty and/or enter a name.");
                alert.show();
            }
        });

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(greeting, comboBox, textField, button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Minesweeper");
        primaryStage.show();
    }

    /**
     * Creates a screen for the Minesweeper game to be played in.
     * @param primaryStage stage to be shown
     * @param gameDifficulty difficulty selected from the drop down menu
     * @param name name entered in the last screen
     */

    public void playMinesweeper(Stage primaryStage, Difficulty gameDifficulty, String name) {
        MinesweeperGame game = new MinesweeperGame((gameDifficulty));
        GridPane grid = new GridPane();
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                Button newTile = createButton();
                grid.add(newTile, y, x);
                Tile tile = new Tile(y, x);
                newTile.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Tile[] arr = game.check(tile.getY(), tile.getX());
                        if (!tile.isMine()) {
                            for (int i = 0; i < arr.length; i++) {
                                for (Node node : grid.getChildren()) {
                                    if (game.isWon()) {
                                        message(primaryStage, true, name);
                                    } else if (arr[i].getY() == GridPane.getColumnIndex(node)
                                            && arr[i].getX() == GridPane.getRowIndex(node)) {
                                        Button bruhMoment = (Button) node;
                                        if (arr[i].getBorderingMines() == -1) {
                                            message(primaryStage, false, name);
                                        } else {
                                            bruhMoment.setText(String.valueOf(arr[i].getBorderingMines()));
                                        }
                                    }
                                }
                            }
                        }
                        if (tile.isMine()) {
                            if (game.isLost()) {
                                message(primaryStage, false, name);
                            }
                        }
                    }
                });
            }
        }

        if (game.isLost()) {
            message(primaryStage, false, name);
        } else if (game.isWon()) {
            message(primaryStage, true, name);
        }

        Label player = new Label("Player: " + name);
        Label title = new Label("Difficulty: " + gameDifficulty);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(title, player, grid);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Minesweeper");
    }

    /**
     * Helper method to create a screen for if the player has won/lost.
     * @param primaryStage stage to be shown to the user
     * @param status whether or not the player has won/lost. false if lost, true if won
     * @param name name of the player
     */

    private void message(Stage primaryStage, boolean status, String name) {
        VBox vBox = new VBox(20);
        Button button = new Button("New Game");
        if (!status) {
            Label label = new Label("You Lost, " + name);
            label.setFont(new Font("Courier New", 20));
            vBox.getChildren().addAll(label, button);
        } else {
            Label label2 = new Label("Congratulations, " + name);
            label2.setFont(new Font("Courier New", 20));
            vBox.getChildren().addAll(label2, button);
        }
        button.setOnAction(new NewGame(primaryStage));

        Scene scene = new Scene(vBox, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Inner class that handles the "New Game" event and launches the start screen again.
     */

    private class NewGame implements EventHandler<ActionEvent> {
        private final Stage mainStage;
        NewGame(Stage primaryStage) {
            mainStage = primaryStage;
        }
        public void handle(ActionEvent actionEvent) {
            start(mainStage);
        }
    }

    /**
     * Helper method to create a button in the button grid.
     * @return a new Button object
     */
    private Button createButton() {
        Button tileButton = new Button("X");
        return tileButton;
    }

    /**
     * Main class to launch the program.
     * @param args command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }
}

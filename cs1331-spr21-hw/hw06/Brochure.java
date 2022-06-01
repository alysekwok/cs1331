import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * @author akwok6
 * @version 1.0
 */

public class Brochure extends Application {

    /**
     * Overrides Application's start() method.
     * @param primaryStage the stage
     */

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("TravelBrochure");

        Text text = new Text();
        text.setText("WELCOME TO OOP-TOPIA!");
        text.setFill(Color.WHITE);
        text.setFont(Font.font("verdana", 35));

        Text text2 = new Text();
        text2.setText("Totoro says OOP-TOPIA is epic");
        text2.setFont(Font.font("verdana", 35));

        Rectangle rectangle = new Rectangle(500, 75, Color.BLUE);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.TOP_LEFT);
        ObservableList list = stackPane.getChildren();
        list.addAll(rectangle, text);

        Image image = new Image("/totoro1.gif");
        ImageView imageView = new ImageView();
        imageView.setImage(image);


        Circle c1 = new Circle();
        c1.setFill(Color.PINK);
        c1.setRadius(50);
        Circle c2 = new Circle();
        c2.setFill(Color.PURPLE);
        c2.setRadius(50);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        ObservableList list2 = hBox.getChildren();
        list2.addAll(c1, imageView, c2);

        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.TOP_CENTER);
        hBox1.setSpacing(10);
        ObservableList list1 = hBox1.getChildren();
        list1.add(text2);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(stackPane);
        borderPane.setCenter(hBox);
        borderPane.setBottom(hBox1);


        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();

    }

    /**
     * The main method that launches the program.
     * @param args command line arguments
     */

    public static void main(String[] args) {
        launch(args);

    }
}

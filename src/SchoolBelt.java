import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Wyatt Hoodes
 */
public class SchoolBelt extends Application {

    //Sets up the initial window
    private GridPane root = new GridPane();
    private HBox buttonBox = new HBox(20);
    private Button calcButton = new Button("Simple Calculator");
    private Button textButton = new Button("Take Notes");
    private Button quadButton = new Button("Quadratic Calculator");

    public void start(Stage stage) {

        //Open CalculatorFX with this button.
        calcButton.setOnAction(e -> {
            CalculatorFX calc = new CalculatorFX();
            Stage calcStage = new Stage();
            calcStage.setScene(new Scene(calc.getRoot()));
            calcStage.show();
        });

        //Open TextEditorFx with this button.
        textButton.setOnAction(e -> {
            TextEditorFX text = new TextEditorFX();
            Stage textStage = new Stage();
            textStage.setScene(new Scene(text.getRoot()));
            textStage.setHeight(400);
            textStage.show();
        });

        quadButton.setOnAction(e -> {
            QuadraticFX quad = new QuadraticFX();
            Stage quadStage = new Stage();
            quadStage.setScene(new Scene(quad.getRoot()));
            quadStage.show();
        });


        buttonBox.getChildren().addAll(calcButton, quadButton, textButton);
        root.add(buttonBox, 1, 3);

        buttonBox.setAlignment(Pos.CENTER);
        root.setStyle("-fx-fill-width: true; -fx-fill-height: true; -fx-padding: 20px 20px 20px 20px; -fx-alignment: center");
        Scene scene = new Scene(root);

        stage.setTitle("School Belt");
        stage.setScene(scene);
        stage.setX(0);
        stage.setY(0);
        stage.show();
    }

}

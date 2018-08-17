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
    private Button textButton = new Button("Simple Text Editor");

    public void start(Stage stage){

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


        buttonBox.getChildren().addAll(calcButton, textButton);
        root.add(buttonBox, 1, 3);

        buttonBox.setAlignment(Pos.CENTER);
        root.setHgap(55);
        root.setVgap(10);
        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("School Belt");
        stage.setScene(scene);
        stage.setHeight(250);
        stage.setResizable(false);
        stage.show();
    }

}

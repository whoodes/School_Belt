
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;

import java.text.DecimalFormat;


public class QuadraticFX {

    private GridPane root = new GridPane();

    private TextField secondDegree = new TextField();
    private TextField firstDegree = new TextField();
    private TextField constant = new TextField();

    private Label equalsZero = new Label("0   =   ");
    private Label xUpTwo = new Label("x^2   +");
    private Label xUpOne = new Label("x   +");
    private Label result = new Label("");

    private HBox equationBox = new HBox();
    private HBox equalsBox = new HBox();
    private HBox resultBox = new HBox();

    private Button equals = new Button("Solve");

    QuadraticFX() { load(); }

    public void load() {

        root.setPadding(new Insets(10, 10, 10, 10));

        equationBox.getChildren().addAll(equalsZero, secondDegree, xUpTwo, firstDegree, xUpOne, constant);
        equationBox.setAlignment(Pos.BASELINE_LEFT);
        secondDegree.setStyle("-fx-pref-width: 50px");
        firstDegree.setStyle("-fx-pref-width: 50px");
        xUpTwo.setStyle("-fx-padding: 0px 15px 0px 5px");
        xUpOne.setStyle("-fx-padding: 0px 15px 0px 5px");
        constant.setStyle("-fx-pref-width: 50px");
        root.add(equationBox, 0, 0);

        equals.setOnAction(new computeHandle());
        equalsBox.getChildren().add(equals);
        equalsBox.setAlignment(Pos.CENTER);
        root.add(equalsBox, 0, 1);

        resultBox.getChildren().add(result);
        root.add(resultBox, 0, 2);

        root.setVgap(25);

    }

    public GridPane getRoot() { return root; }

    private class computeHandle implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

            try {

                double aValue = Double.parseDouble(secondDegree.getText());
                double bValue = Double.parseDouble(firstDegree.getText());
                double cValue = Double.parseDouble(constant.getText());
                double discriminant = (bValue * bValue) - (4 * aValue * cValue);
                double root1;
                double root2;

                if(discriminant < 0) {
                    result.setText("No Real solution");
                }else if(discriminant == 0 ){
                    root1 = (bValue * -1) / (2 * aValue);
                    result.setText("One Real solution: " + Double.toString(root1));
                }else {
                    root1 = (-bValue + Math.sqrt(discriminant)) / (2 * aValue);
                    root2 = (-bValue - Math.sqrt(discriminant)) / (2 * aValue);

                    DecimalFormat rootFormat = new DecimalFormat("#.###");
                    double fRoot1 = Double.valueOf(rootFormat.format(root1));
                    double fRoot2 = Double.valueOf(rootFormat.format(root2));

                    result.setText("Two Real solutions: " + Double.toString(fRoot1) + ", " + Double.toString(fRoot2));
                }

            } catch (Exception ex) {
                result.setText("Oops..");
            }

        }

    }

}

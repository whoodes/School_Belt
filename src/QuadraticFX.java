
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

        equalsBox.getChildren().add(equals);
        equalsBox.setAlignment(Pos.CENTER);
        root.add(equalsBox, 0, 1);

        resultBox.getChildren().add(result);

        root.setVgap(25);

    }

    public GridPane getRoot() { return root; }

    private class compute implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

            try {
                //Code

            } catch (Exception ex) {
                System.out.println("Oops..");
            }

        }

    }

}

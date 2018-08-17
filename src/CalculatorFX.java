import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * @author Wyatt Hoodes
 */
class CalculatorFX {


    private double firstValue;
    private String operator;

    //TextFields to hold user input.
    private TextField firstField = new TextField();
    private TextField secondField = new TextField();

    //Empty label designated to hold displayableResult.
    private Label result = new Label("");

    //Operator buttons.
    private Button add = new Button("+");
    private Button subtract = new Button("-");
    private Button multiply = new Button("*");
    private Button divide = new Button("/");
    private Button equals = new Button("=");

    //The root node.
    private GridPane root = new GridPane();

    /**
     * Constructor that loads up the calculator.
     */
    CalculatorFX(){ load(); }

    /**
     * The load function to build the calculator.
     */
    private void load() {

        //3 HBox's for all the rows except the result.
        HBox operatorBox = new HBox(5);
        HBox firstNumberBox = new HBox(29);
        HBox secondNumberBox = new HBox(20);

        //GridPane as the root node. Tweaked to desired specs.
        root.setPadding(new Insets(15, 15, 15, 15));
        root.setHgap(20);
        root.setVgap(15);
        root.setStyle("-fx-background-color: white;");

        //Place strings in the labels and adjust the font size of result.
        Label firstNumber = new Label("First number");
        Label secondNumber = new Label("Second number");
        result.setStyle("-fx-font-size: 15;");

        //Place the firstNumber and firstField in the firstBox, align, and add to root.
        firstNumberBox.getChildren().add(firstNumber);
        firstNumberBox.getChildren().add(firstField);
        firstNumberBox.setAlignment(Pos.BASELINE_RIGHT);
        root.add(firstNumberBox, 0, 0);

        //Add the operator box and position to center.
        root.add(operatorBox, 0, 1);
        operatorBox.setAlignment(Pos.CENTER);

        //Add the secondNumber and secondField to the secondNumberBox. Align and add to the root.
        secondNumberBox.getChildren().add(secondNumber);
        secondNumberBox.getChildren().add(secondField);
        secondNumberBox.setAlignment(Pos.BASELINE_RIGHT);
        root.add(secondNumberBox, 0, 2);

        //A Button array used in the following for each loop.
        Button[] buttons = {add, subtract, multiply, divide};

        for (Button button : buttons) {

            //Style it up.
            button.setStyle("-fx-padding: 15px 25px; -fx-background-radius: 20; -fx-background-color: white;"
                    + "-fx-border-color: white; -fx-border-radius: 20;");

            //Everything in its right place.
            operatorBox.getChildren().add(button);

            //Mouse Entered.
            button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));

            //Mouse Exited.
            button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));

            //Mouse Pressed.
            button.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> button.setEffect(new InnerShadow()));

            //Mouse Released.
            button.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> button.setEffect(null));

            //Call the operatorHandle class.
            button.setOnAction(new operatorHandle());

        }

        //Equals button is the odd ball button child, so properties are applied uniquely.
        root.add(equals, 0, 3);

        //Style the button.
        equals.setStyle("-fx-padding: 15px 100px; -fx-background-radius: 20; -fx-background-color: white;"
                + "-fx-border-color: white; -fx-border-radius: 20;");

        //Mouse entered.
        equals.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> equals.setEffect(new DropShadow()));

        //Mouse exited.
        equals.addEventHandler(MouseEvent.MOUSE_EXITED, e -> equals.setEffect(null));

        //Mouse pressed.
        equals.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> equals.setEffect(new InnerShadow()));

        //Mouse released.
        equals.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> equals.setEffect(null));

        //Set the action.
        equals.setOnAction(new displayResultsHandle());

        //Align the equals button
        GridPane.setHalignment(equals, HPos.CENTER);

        //Add the result node to the root.
        root.add(result, 0, 4);

    }

    /**
     * Gets the root node for setting in a scene.
     *
     * @return The root node as a GridPane.
     */
    GridPane getRoot(){ return root; }

    /**
     * Displays the result of the operation based on user input.
     */
    private class displayResultsHandle implements EventHandler<ActionEvent>{

        double displayableResult;

        public void handle(ActionEvent e) {

            try {

                //Capture the value in the second textField
                double secondValue = Double.parseDouble(secondField.getText());

                //If the first field is empty throw an exception.
                if(firstField.getText().isEmpty())
                    throw new Exception();

                //Perform operation based on operator string value.
                switch(operator) {
                    case "add": displayableResult = firstValue + secondValue;
                        break;
                    case "sub": displayableResult = firstValue - secondValue;
                        break;
                    case "multiply": displayableResult = firstValue * secondValue;
                        break;
                    case "div": displayableResult = firstValue / secondValue;
                        break;
                    default: displayableResult = 0;
                        break;
                }

                //Display the result.
                result.setText(Double.toString(displayableResult));

            }catch(Exception ex) {
                result.setText("Oops..");
            }
        }
    }

    /**
     * Based on the event, determines which operation is taking place.
     */
    private class operatorHandle implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

            try {

                //Capture the value in the first textField. Assign the global value to the number.
                firstValue = Double.parseDouble(firstField.getText());

                //if-then block determining the operation.
                if(e.getSource() == add)
                    operator = "add";
                else if(e.getSource() == subtract)
                    operator = "sub";
                else if(e.getSource() == multiply)
                    operator = "multiply";
                else if(e.getSource() == divide)
                    operator = "div";

            }catch(Exception ex) {
                result.setText("Oops..");
            }
        }
    }

}

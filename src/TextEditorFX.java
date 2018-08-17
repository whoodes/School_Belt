
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.event.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Text editor GUI class.
 *
 * @author Wyatt Hoodes
 */
public class TextEditorFX {

    private final Menu FILE = new Menu("File");

    private  BorderPane root = new BorderPane();

    //Keyboard shortcut for saving a file//
    private static final KeyCombination saveShortcut =
            new KeyCodeCombination(KeyCode.S, KeyCombination.SHORTCUT_DOWN);

    //Keyboard shortcut for opening a file//
    private static final KeyCombination openShortcut =
            new KeyCodeCombination(KeyCode.O, KeyCombination.SHORTCUT_DOWN);


    private TextArea textEdit = new TextArea();
    private MenuBar mainMenu = new MenuBar();
    private MenuItem open = new MenuItem("Open...\t\t\t\t");
    private MenuItem save = new MenuItem("Save...");

    /**
     * Constructor for a TextEditor
     */
    public TextEditorFX(){ load(); }

    /**
     * A method to load up the text editor.
     */
    public void load(){


        //Create a TextArea and turn on the WrapText function//
        textEdit.setWrapText(true);

        //Create an "Open" item, set the shortcut//
        open.setAccelerator(openShortcut);

        //Create a "Save" item, set the shortcut//
        save.setAccelerator(saveShortcut);

        //Setting the action for "Open" event//
        open.setOnAction((ActionEvent event) -> {

            //Create a new FileChooser and assign a new FILE to the FileChooser dialog//
            FileChooser myFile = new FileChooser();
            File openFile = myFile.showOpenDialog(new Stage());

            //openFile must exist//
            if(openFile != null) {

                //Clear the textView//
                textEdit.setText(null);
                try {

                    //While the scanner has input, read it to the textView//
                    Scanner input = new Scanner(openFile);
                    while(input.hasNext()) {
                        textEdit.appendText(input.nextLine() + "\n");
                    }
                    input.close();

                }catch(IOException e) {
                    System.out.println("An error occurred.");
                }

            }

        });

        //Setting the action for "Save" event//
        save.setOnAction((ActionEvent event) -> {

            //Create a new FileChooser and assign a new FILE to the FileChooser dialog//
            FileChooser myFile = new FileChooser();
            File saveFile = myFile.showSaveDialog(new Stage());

            //saveFile must exist//
            if(saveFile != null) {

                try {

                    saveFile.createNewFile();
                    PrintWriter output = new PrintWriter(saveFile);
                    output.print(textEdit.getText());
                    output.close();

                }catch(IOException e) {
                    System.out.println("An error occurred.");
                }

            }

        });

        //Add the items to the FILE menu, add the FILE menu to the bar, display the menu bar
        FILE.getItems().addAll(open, save);
        mainMenu.getMenus().add(FILE);
        mainMenu.setUseSystemMenuBar(true);


        root.setTop(mainMenu);
        root.setCenter(textEdit);
        root.setStyle("-fx-padding: 10 20 10 20; -fx-border-color: black;");
    }

    public BorderPane getRoot(){ return root; }

}
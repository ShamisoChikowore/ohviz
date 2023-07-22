package cs.sun.za.ohviz.layout;

import cs.sun.za.ohviz.utilities.AutomatonType;
import cs.sun.za.ohviz.utilities.DFAFIleHandler;
import cs.sun.za.ohviz.utilities.NFAFileHandler;
import cs.sun.za.ohviz.utilities.XNFAHandler;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AppLayout {
    MenuBar menuBar;
    Stage stage;
    public AppLayout(MenuBar menuBar, Stage stage) {
        this.menuBar = menuBar;
        this.stage = stage;

        addFileMenu();
        addLayoutAlgorithmsMenu();
        addManipulationAlgorithmsMenu();
    }

    private void addManipulationAlgorithmsMenu() {
        Menu algorithmsMenu = new Menu("Algorithms");
        MenuItem minimiseDFA = new MenuItem("Minimize Dfa");
        algorithmsMenu.getItems().add(minimiseDFA);
        minimiseDFA.setOnAction(event -> {
//            MinimizeDFA.getUnreachableStates(currentDFA);
        });
        menuBar.getMenus().add(algorithmsMenu);
    }

    private void addLayoutAlgorithmsMenu() {
        Menu viewMenu = new Menu("Layout");
        menuBar.getMenus().add(viewMenu);
    }

    private void addFileMenu() {
        Menu fileMenu = new Menu("File");

        MenuItem openDFA = new MenuItem("Open Dfa");
        openDFA.setOnAction(event -> {processInputFile(AutomatonType.DFA);});

        MenuItem openNFA = new MenuItem("Open NFA");
        openNFA.setOnAction(event -> {processInputFile(AutomatonType.NFA);});

        MenuItem openXNFA = new MenuItem("Open XNFA");
        openXNFA.setOnAction(event -> {processInputFile(AutomatonType.XNFA);});

        fileMenu.getItems().add(openDFA);
        fileMenu.getItems().add(openNFA);
        fileMenu.getItems().add(openXNFA);
        fileMenu.getItems().add(new MenuItem("Save As"));

        menuBar.getMenus().add(fileMenu);
    }

    private void processInputFile(AutomatonType automatonType){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (automatonType == AutomatonType.DFA) {
            new DFAFIleHandler(selectedFile);
        } else if (automatonType == AutomatonType.NFA) {
            new NFAFileHandler(selectedFile);
        } else if (automatonType == AutomatonType.XNFA) {
            new XNFAHandler(selectedFile);
        }

    }
    //after reading in display with defaultLayout on tab
    // given current view allow differernt layouys
    //Keep track of selected tab so that you knw which layout to change

}

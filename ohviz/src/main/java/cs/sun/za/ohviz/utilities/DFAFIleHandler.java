package cs.sun.za.ohviz.utilities;

import cs.sun.za.ohviz.stateMachines.Dfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DFAFIleHandler extends FileHandler {
    public Dfa currentDFA;

    public DFAFIleHandler(File inputFile) {
        try {
            Scanner scanner = new Scanner(inputFile);
            String automatonType = scanner.nextLine().strip();
            if (automatonType.equals("dfa")) {
                ArrayList<String> states = getAllStates(scanner.nextLine().strip());
                String startState = getStartState(scanner.nextLine().strip());
                ArrayList<String> acceptingStates =  getAcceptingStates(scanner.nextLine());
                ArrayList<String> alphabet = getAlphabet(scanner.nextLine());
                ArrayList<ArrayList<String>> transitionTable = getTransitions(scanner, states, alphabet);
                printTransitionTable(transitionTable, alphabet.size());

                Dfa dfa = new Dfa(states, startState, acceptingStates, alphabet, transitionTable);
                this.currentDFA = dfa;

                } else {
                // Todo: log error
                System.out.println("Not a dfa");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

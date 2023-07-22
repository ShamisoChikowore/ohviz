/**
 * Handles methods used to extract automaton details from input file
 */
package cs.sun.za.ohviz.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    File inputFile;

    public void printTransitionTable(ArrayList<ArrayList<String>> transitionTable, int alphabetSize) {
        for (int i = 0; i < transitionTable.size(); i++) {
            for (int j = 0; j < transitionTable.get(i).size(); j++) {
                System.out.print((transitionTable.get(i)).get(j) + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<String> getAllStates(String statesLine) {
        String[] statesArray = statesLine.split(" ");
         ArrayList<String> states = new ArrayList<>();
        for (String state: statesArray) {
            states.add(state.strip());
        }

        System.out.println(" State line = " + statesLine + " " + states + "\n");
        return states;
    }
    public String getStartState(String startStateLine) {
        String initialState = startStateLine.strip();
        System.out.println(" Start State line = " + initialState + "\n");
        return initialState;
    }

    public ArrayList<String> getAcceptingStates(String acceptingStatesLine) {
        String[] acceptingStatesArray = acceptingStatesLine.split(" ");
        ArrayList<String> acceptingStates = new ArrayList<>(0);
        for (String state: acceptingStatesArray) {
            acceptingStates.add(state.strip());
        }
        System.out.println(" Final States line = " + acceptingStatesLine + " " + acceptingStates + "\n");
        return acceptingStates;
    }

    public ArrayList<String> getAlphabet(String alphabetLine){
        String[] alphabetArray = alphabetLine.split(" ");
        ArrayList<String> alphabet = new ArrayList<>(0);
        for (String inputSymbol: alphabetArray) {
            alphabet.add(inputSymbol.strip());
        }
        System.out.println(" alphabet = " + alphabetLine + " " + alphabet + "\n");
        return alphabet;
    }

    public  ArrayList<ArrayList<String>>  getTransitions(Scanner scanner, ArrayList<String> states, ArrayList<String> alphabet) {
        ArrayList<ArrayList<String>> transitionTable = new ArrayList<>();

        //Create rows
        for (int i = 0; i < states.size(); i++) {
            ArrayList<String> innerList = new ArrayList<>(0);

            for (int j = 0; j < alphabet.size(); j++) {
                innerList.add(null);
            }
            transitionTable.add(innerList);
        }

        while (scanner.hasNextLine()) {
            String transitionFunctionLine = scanner.nextLine();
            String[] transitionFunctionArray = transitionFunctionLine.split(" ");

            if (transitionFunctionArray.length == 3) {
                String sourceState = transitionFunctionArray[0].strip();
                String symbol = transitionFunctionArray[1].strip();
                String destinationState = transitionFunctionArray[2].strip();

                if (states.contains(sourceState) && alphabet.contains(symbol) && states.contains(sourceState)) {
                    System.out.println("Index of source state " + states.indexOf(sourceState));
                    System.out.println("Index of alphabet " + alphabet.indexOf(symbol));
                    System.out.println("Table size: " + transitionTable.size() + ". Alphabet size " + alphabet.size() + ". States size " + states);

                    transitionTable.get(states.indexOf(sourceState)).set(alphabet.indexOf(symbol), destinationState);
                } else {
                    //todo: handle error
                }

                // We use integers to ensure that states in the transition table are if

            } else {
                //todo: handle error
            }
        }
        return transitionTable;
    }
}

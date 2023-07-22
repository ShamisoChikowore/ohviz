package cs.sun.za.ohviz.stateMachines;

import java.util.ArrayList;

public class Dfa {
    public ArrayList<ArrayList<String>> transitionTable;
    public ArrayList<String> acceptingStates;
    public ArrayList<String> states;

    public ArrayList<String> alphabet;
    private String currentState;
    String initialState;

    public Dfa() {}

    public Dfa(ArrayList<String> states, String initialState, ArrayList<String> acceptingStates, ArrayList<String> alphabet, ArrayList<ArrayList<String>> transitionTable) {
        this.states = states;
        this.initialState = initialState;
        this.acceptingStates = acceptingStates;
        this.alphabet = alphabet;
        this.transitionTable = transitionTable;
    }
}

package org.example;

public class TestAutomaton {
    enum State {
        S, State_1, State_2, State_3, F
    }

    public State processString(String input) {
        State state = State.S;

        for (char c : input.toCharArray()) {
            switch (state) {
                case S:
                    if (c == 'T') {
                        state = State.State_1;
                    }
                    break;
                case State_1:
                    if (c == 'E') {
                        state = State.State_2;
                    } else if (c == 'T') {
                        state = State.State_1;
                    } else {
                        state = State.S;
                    }
                    break;
                case State_2:
                    if (c == 'S') {
                        state = State.State_3;
                    } else if (c == 'E') {
                        state = State.State_2;
                    } else {
                        state = State.S;
                    }
                    break;
                case State_3:
                    if (c == 'T') {
                        state = State.F;
                    } else if (c == 'S') {
                        state = State.State_3;
                    } else {
                        state = State.S;
                    }
                    break;
                case F:
                    break;
            }
        }

        return state;
    }
}




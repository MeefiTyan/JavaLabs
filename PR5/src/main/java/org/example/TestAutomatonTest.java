package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Stream;

class TestAutomatonTest {

    private TestAutomaton automaton;

    @BeforeEach
    void setUp() {
        automaton = new TestAutomaton();
    }

    @MethodSource("inputStrings")
    @ParameterizedTest
    void testProcessString(String input, TestAutomaton.State expectedState) {
        TestAutomaton.State actualState = automaton.processString(input);
        assertEquals(expectedState, actualState);
    }

    static Stream<Arguments> inputStrings() {
        return Stream.of(
                Arguments.of("abcTESTabc", TestAutomaton.State.F),
                Arguments.of("aT", TestAutomaton.State.State_1),
                Arguments.of("aTE", TestAutomaton.State.State_2),
                Arguments.of("abcTES", TestAutomaton.State.State_3),
                Arguments.of("a", TestAutomaton.State.S),
                Arguments.of("", TestAutomaton.State.S),
                Arguments.of("TEEST", TestAutomaton.State.F),
                Arguments.of("TTEST", TestAutomaton.State.F),
                Arguments.of("TESST", TestAutomaton.State.F)
        );
    }
}



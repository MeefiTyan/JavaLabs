package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Ділення на нуль неможливе!", exception.getMessage());
    }

    @Test
    void testSqrtOfNegativeNumber() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            calculator.sqrt(-1);
        });

        assertEquals("Корінь з від'ємного числа неможливий!", exception.getMessage());
    }

    @Test
    public void testInputMismatchException() {
        Scanner scanner = new Scanner("Помилка введення: будь ласка, введіть число.");
        assertThrows(InputMismatchException.class, () -> {
            double a = scanner.nextDouble();
        });
    }
}



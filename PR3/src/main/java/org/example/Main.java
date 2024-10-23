package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введіть перше число:");
            double num1 = scanner.nextDouble();

            System.out.println("Введіть друге число:");
            double num2 = scanner.nextDouble();

            System.out.println("Оберіть операцію (+, -, *, /, sqrt):");
            String operation = scanner.next();

            double result;

            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    System.out.println("Результат додавання: " + result);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    System.out.println("Результат віднімання: " + result);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    System.out.println("Результат множення: " + result);
                    break;
                case "/":
                    result = calculator.divide(num1, num2);
                    System.out.println("Результат ділення: " + result);
                    break;
                case "sqrt":
                    result = calculator.sqrt(num1);
                    System.out.println("Квадратний корінь з " + num1 + ": " + result);
                    break;
                default:
                    System.out.println("Невідома операція.");
            }

        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Невірне введення: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Помилка введення: будь ласка, введіть число.");
        } finally {
            System.out.println("Обробка запиту завершена.");
            scanner.close();
        }
    }
}
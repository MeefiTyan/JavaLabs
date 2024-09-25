package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class TransactionAnalyzerTest {
    @Test
    public void testCalculateTotalBalance() {
        // Створення тестових даних
        Transaction transaction1 = new Transaction("2023-01-01", 100.0, "Дохід");
        Transaction transaction2 = new Transaction("2023-01-02", -50.0, "Витрата");
        Transaction transaction3 = new Transaction("2023-01-03", 150.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);


        // Виклик методу, який потрібно протестувати
        double result = TransactionAnalyzer.calculateTotalBalance(transactions);

        // Перевірка результату
        Assertions.assertEquals(200.0, result, "Розрахунок загального балансу неправильний");
    }
    @Test
    public void testCountTransactionsByMonth() {
        // Підготовка тестових даних
        Transaction transaction1 = new Transaction("01-02-2023", 50.0, "Дохід");
        Transaction transaction2 = new Transaction("15-02-2023", -20.0, "Витрата");
        Transaction transaction3 = new Transaction("05-03-2023", 100.0, "Дохід");
        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);


        int countFeb = TransactionAnalyzer.countTransactionsByMonth("02-2023",transactions);
        int countMar = TransactionAnalyzer.countTransactionsByMonth("03-2023",transactions);

        // Перевірка результатів
        Assertions.assertEquals(2, countFeb, "Кількість транзакцій за лютий неправильна");
        Assertions.assertEquals(1, countMar, "Кількість транзакцій за березень неправильна");
    }

    @Test
    public void testFindTopExpenses() {

        Transaction transaction1 = new Transaction("01-01-2023", -500.0, "Shopping");
        Transaction transaction2 = new Transaction("02-01-2023", -200.0, "Groceries");
        Transaction transaction3 = new Transaction("03-01-2023", -150.0, "Utilities");
        Transaction transaction4 = new Transaction("04-01-2023", -800.0, "Rent");
        Transaction transaction5 = new Transaction("05-01-2023", 1000.0, "Salary");

        List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3, transaction4, transaction5);

        List<Transaction> topExpenses = TransactionAnalyzer.findTopExpenses(transactions);

        Assertions.assertEquals(3, topExpenses.size(), "Неправильна кількість найбільших витрат");

        Assertions.assertEquals(transaction4, topExpenses.get(0), "Неправильний перший найбільший витрата");
        Assertions.assertEquals(transaction1, topExpenses.get(1), "Неправильний другий найбільший витрата");
        Assertions.assertEquals(transaction2, topExpenses.get(2), "Неправильний третій найбільший витрата");
    }

}

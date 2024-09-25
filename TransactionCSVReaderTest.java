package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class TransactionCSVReaderTest {
    @Test
    public void testReadTransactions() {
        String testFilePath = "https://example.com/test_transactions.csv";


        List<Transaction> transactions = TransactionCSVReader.readTransactions(testFilePath);

        Assertions.assertNotNull(transactions, "Список транзакцій не повинен бути null");
        Assertions.assertTrue(transactions.size() > 0, "Список транзакцій не повинен бути порожнім");

        Transaction firstTransaction = transactions.get(0);
        Assertions.assertEquals("01-01-2023", firstTransaction.getDate(), "Неправильна дата");
        Assertions.assertEquals(100.0, firstTransaction.getAmount(), "Неправильна сума");
        Assertions.assertEquals("Income", firstTransaction.getDescription(), "Неправильний опис");
    }
}

package com.example.budget.service;

import com.example.budget.model.Transaction;
import com.example.budget.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Implement service methods for CRUD operations
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Define a method to create a new transaction
    public Transaction createTransaction(Transaction transaction) {
        // You can add additional logic here before saving to the database, if needed
        return transactionRepository.save(transaction);
    }

    // Define a method to update an existing transaction by ID
    public Transaction updateTransaction(Long id, Transaction transaction) {
        // Check if the transaction with the given ID exists
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));

        // Update the existing transaction's properties
        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setDate(transaction.getDate());

        // Save the updated transaction
        return transactionRepository.save(existingTransaction);
    }

    // Define a method to delete a transaction by ID
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}


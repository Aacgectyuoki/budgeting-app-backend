package com.example.budget.controller;

import com.example.budget.model.Transaction;
import com.example.budget.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/transactions")
//public class TransactionController {
//    private final TransactionService transactionService;
//
//    @Autowired
//    public TransactionController(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
//
//    // Define API endpoints for CRUD operations
//}

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Define API endpoint to retrieve all transactions (GET)
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Define API endpoint to create a new transaction (POST)
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    // Define API endpoint to update an existing transaction (PUT)
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        return transactionService.updateTransaction(id, transaction);
    }

    // Define API endpoint to delete a transaction by ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().build();
    }
}

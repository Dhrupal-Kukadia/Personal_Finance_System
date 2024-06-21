package org.finance.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;
import org.finance.model.Transaction;
import org.finance.repository.TransactionRepository;

import java.util.List;

@ApplicationScoped
public class TransactionService {
    @Inject
    TransactionRepository transactionRepository;

    public void createTransaction(Transaction transaction) {
        transactionRepository.persist(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.listAll();
    }

    public Transaction findById(String id) {
        return transactionRepository.findById(new ObjectId(id));
    }
}

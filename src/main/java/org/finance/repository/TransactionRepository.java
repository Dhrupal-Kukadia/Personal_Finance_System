package org.finance.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.finance.model.Transaction;

@ApplicationScoped
public class TransactionRepository implements PanacheMongoRepository<Transaction> {
}

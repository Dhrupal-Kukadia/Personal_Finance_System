package org.finance.dto;

import org.finance.model.Action;
import org.finance.model.Transaction;

public class TxAdditionDTO {
    private String userId;
    private double amount;
    private Action action;
    private String category;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Transaction createTransactionFromDTO() {
        Transaction transaction = new Transaction();
        transaction.setUserId(this.userId);
        transaction.setTimestamp(System.currentTimeMillis());
        transaction.setAmount(this.amount);
        transaction.setAction(this.action);
        transaction.setCategory(this.category);
        return transaction;
    }
}

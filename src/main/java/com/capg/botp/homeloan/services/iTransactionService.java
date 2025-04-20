package com.capg.botp.homeloan.services;

import com.capg.botp.homeloan.models.Transaction;

import java.util.List;


public interface iTransactionService {

    public Transaction addTransaction(Transaction trans);

    public List<Transaction> getTransactionsByCustId(int custId);
}

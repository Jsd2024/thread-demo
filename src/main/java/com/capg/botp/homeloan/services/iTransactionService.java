package com.capg.botp.homeloan.services;

import com.capg.botp.homeloan.models.Transaction;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public interface iTransactionService {

    public Transaction addTransaction(Transaction trans);

    public List<Transaction> getTransactionsByCustId(int custId);
}

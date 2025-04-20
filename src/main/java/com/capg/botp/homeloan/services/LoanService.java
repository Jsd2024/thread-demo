package com.capg.botp.homeloan.services;

import com.capg.botp.homeloan.models.Loan;

import java.util.List;

public interface LoanService {

    public Loan applyLoan(Loan l);

    public List<Loan> getLoansByCustomerId(int custId);

    public void foreCloseLoan(int loanId);
}

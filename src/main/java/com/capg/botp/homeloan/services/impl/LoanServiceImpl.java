package com.capg.botp.homeloan.services.impl;

import com.capg.botp.homeloan.dao.CustomerRepository;
import com.capg.botp.homeloan.dao.LoanRepository;
import com.capg.botp.homeloan.exceptions.CustomerNotFoundException;
import com.capg.botp.homeloan.exceptions.LoanNotFoundException;
import com.capg.botp.homeloan.models.Customer;
import com.capg.botp.homeloan.models.Loan;
import com.capg.botp.homeloan.services.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanDao;

    @Autowired
    private CustomerRepository customerDao;

    private Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    public Loan applyLoan(Loan loan) {
        int customerId = loan.getCustomer().getId();
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + customerId));
        customer.addLoan(loan);
        return loanDao.save(loan);
    }

    @Override
    public List<Loan> getLoansByCustomerId(int customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + customerId));
        return customer.getLoans();
    }

    @Override
    public void foreCloseLoan(int loanId) {
        Loan loan = loanDao.findById(loanId).orElseThrow(() -> new LoanNotFoundException("Loan Not Found: " + loanId));
        loanDao.delete(loan);
    }
}

package com.capg.botp.homeloan.dao;

import com.capg.botp.homeloan.models.Customer;
import com.capg.botp.homeloan.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository  extends JpaRepository<Loan, Integer> {

    @Query("select l from Loan l where l.id=?1")
    Customer findByCustomerId(int custId);
}
package com.capg.botp.homeloan.controllers;

import com.capg.botp.homeloan.models.Loan;
import com.capg.botp.homeloan.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loan")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired(required = true)
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {

        return new ResponseEntity<Loan>(loanService.applyLoan(loan), HttpStatus.OK);

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable int id) {
        return new ResponseEntity<List<Loan>>(loanService.getLoansByCustomerId(id), HttpStatus.OK);
    }

    @DeleteMapping("/foreclose/{loanId}")
    public ResponseEntity<String> forecloseLoan(@PathVariable int loanId) {
        loanService.foreCloseLoan(loanId);
        return new ResponseEntity<String>("Loan Foreclosed with Loan Id: " + loanId, HttpStatus.OK);
    }

}

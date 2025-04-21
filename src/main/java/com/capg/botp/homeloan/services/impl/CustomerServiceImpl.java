package com.capg.botp.homeloan.services.impl;

import java.util.List;

import com.capg.botp.homeloan.dao.CustomerRepository;
import com.capg.botp.homeloan.exceptions.CustomerNotFoundException;
import com.capg.botp.homeloan.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.capg.botp.homeloan.services.iCustomerService;


@Service
@Primary
public class CustomerServiceImpl implements  iCustomerService{

    @Autowired
    private CustomerRepository customerDao;

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Customer addCustomer(Customer c) {
//        Customer customer = customerDao.checkCustomer(c.getEmail(), c.getAdhaar(), c.getPan(), c.getPhone());
//        if (customer != null) {
//            throw new CustomerAlreadyRegisteredException("Customer Already Registered: " + customer.getId());
//        }
        return customerDao.save(c);
    }

    @Override
    public Integer doLogin(String email, String password) {
        Integer customerId = null;
        try {
            customerId = customerDao.findCustomerByEmailAndPassword(email, password);
            logger.info("Customer: " + customerId + " Logged In Successfully");
            return customerId;
        } catch (Exception e) {
            throw new CustomerNotFoundException("Customer Not Found: " + customerId);
        }
    }

    public Customer updateCustomer(Customer c) {
        Customer customer = customerDao.findById(c.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + c.getId()));
        BeanUtils.copyProperties(c, customer);
        return customerDao.save(customer);
    }

    @Override
    public List<Customer> getCustomers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return customerDao.findAll(pageable).toList();
    }

    @Override
    public Customer getCustomerById(int customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found: " + customerId));
        logger.info("Customer Found: " + customerId);
        return customer;
    }

}
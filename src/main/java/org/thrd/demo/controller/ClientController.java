package org.thrd.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thrd.demo.model.Account;
import org.thrd.demo.worker.AccountHolder;
@RequestMapping("/api")
@RestController
public class ClientController {

    @RequestMapping("/withdraw")
    public void withdraw()
    {
        Account account = new Account();
        AccountHolder accountHolder = new AccountHolder(account);
        Thread t1 = new Thread(accountHolder);
        Thread t2 = new Thread(accountHolder);
        t1.setName("Jack");
        t2.setName("Joya");

        t1.start();
        t2.start();
    }
}

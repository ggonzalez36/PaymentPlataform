package com.peiGo.paymentPlataform.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peiGo.paymentPlataform.demo.model.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.model.entity.DestinationAccount;
import com.peiGo.paymentPlataform.demo.model.request.TransactionRequest;
import com.peiGo.paymentPlataform.demo.model.response.TransactionResponse;
import com.peiGo.paymentPlataform.demo.service.AccountService;
import com.peiGo.paymentPlataform.demo.service.TransactionService;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    
    @RequestMapping(value = "createOriginAccount", method = RequestMethod.POST)
    public String createOrigin(@RequestBody OriginAccount origin){
        return accountService.createoriginAccount(origin);
    }

        
    @RequestMapping(value = "createDestinationAccount", method = RequestMethod.POST)
    public String createDestination(@RequestBody DestinationAccount destination){
        return accountService.createdestinationAccount(destination);
    }

    
    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "generateTransaction", method = RequestMethod.POST)
    public TransactionResponse generateTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.generateTransaction(transactionRequest);
    }

}

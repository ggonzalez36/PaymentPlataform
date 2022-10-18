package com.peiGo.paymentPlataform.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.peiGo.paymentPlataform.demo.model.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.model.entity.Transaction;
import com.peiGo.paymentPlataform.demo.model.entity.Client;
import com.peiGo.paymentPlataform.demo.model.entity.DestinationAccount;
import com.peiGo.paymentPlataform.demo.model.request.TransactionRequest;
import com.peiGo.paymentPlataform.demo.model.response.TransactionResponse;
import com.peiGo.paymentPlataform.demo.service.AccountService;
import com.peiGo.paymentPlataform.demo.service.ClientService;
import com.peiGo.paymentPlataform.demo.service.TransactionService;

import java.util.List;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/paymentPlataform/peiGo/v1")
public class PaymentController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    
    @RequestMapping(value = "/createOriginAccount", method = RequestMethod.POST)
    public String createOrigin(@RequestBody OriginAccount origin){
        return accountService.createoriginAccount(origin);
    }

        
    @RequestMapping(value = "/createDestinationAccount", method = RequestMethod.POST)
    public String createDestination(@RequestBody DestinationAccount destination){
        return accountService.createdestinationAccount(destination);
    }


    @RequestMapping(value = "/generateTransaction", method = RequestMethod.POST)
    public TransactionResponse generateTransaction(@RequestBody TransactionRequest transactionRequest){
        return transactionService.generateTransaction(transactionRequest);
    }

    @RequestMapping(value = "/createClient", method = RequestMethod.POST)
    public String createCLient(@RequestBody Client client){
        return clientService.createCLient(client);
    }

    @RequestMapping(value = "/getOrigin/{id}", method = RequestMethod.GET)
    public OriginAccount getOrigin(@PathVariable int id){
        return accountService.getOrigin(id);
    }

    @RequestMapping(value = "/getDestination/{id}", method = RequestMethod.GET)
    public DestinationAccount getDestination(@PathVariable int id){
        return accountService.getDestination(id);
    }

    @RequestMapping(value = "/getTransaction/{id}", method = RequestMethod.GET)
    public List<Transaction> getTransactionsbyAccount(@PathVariable int id){
        return transactionService.getTransactionsbyAccount(id);
    }





}

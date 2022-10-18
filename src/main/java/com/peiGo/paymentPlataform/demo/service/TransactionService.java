package com.peiGo.paymentPlataform.demo.service;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiGo.paymentPlataform.demo.model.entity.DestinationAccount;
import com.peiGo.paymentPlataform.demo.model.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.model.entity.Transaction;
import com.peiGo.paymentPlataform.demo.model.repository.DestinationAccountRepository;
import com.peiGo.paymentPlataform.demo.model.repository.OriginAccountRepository;
import com.peiGo.paymentPlataform.demo.model.repository.TransactionRepository;
import com.peiGo.paymentPlataform.demo.model.request.TransactionRequest;
import com.peiGo.paymentPlataform.demo.model.response.TransactionResponse;

import reactor.core.publisher.Flux;

import javax.transaction.Transactional;

import java.util.Calendar;
import java.util.List;


@Service
public class TransactionService {

    @Autowired
    private OriginAccountRepository originAccountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private DestinationAccountRepository destinationAccountRepository;
    

    @Transactional
    public TransactionResponse generateTransaction(TransactionRequest transactionRequest){
        try {
            if (originAccountRepository.existsById(transactionRequest.getOriginAccountId())&& destinationAccountRepository.existsById(transactionRequest.getDestinationAccountId())){

                TransactionResponse transactionresponse= createTransaction(transactionRequest);
                return transactionresponse;
            }else {
                throw new TransactionException("orgin Account or destination account does not exist");
            }
        }catch (Exception e){
            throw e;
        }
    }


    private TransactionResponse createTransaction(TransactionRequest transactionRequest) {



      // int transactionid = transactionRepository.findMaxId()+1;
      int transactionid=1;
   
       OriginAccount origin  = originAccountRepository.findByOriginAccountId(transactionRequest.getOriginAccountId());
       DestinationAccount destination  = destinationAccountRepository.findByDestinationAccountId(transactionRequest.getOriginAccountId());
       if(origin.getAccountBalance().compareTo( transactionRequest.getTransactionAmount())>=0){

        origin.setAccountBalance(origin.getAccountBalance().subtract(transactionRequest.getTransactionAmount()));
        destination.setAccountBalance(destination.getAccountBalance().add(transactionRequest.getTransactionAmount()));

        originAccountRepository.save(origin);
        destinationAccountRepository.save(destination);

       }else {
        throw new TransactionException("insufficient funds to complete this transaction");
       }
       

        java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        TransactionResponse transactionresponse= TransactionResponse.builder().transactionId(transactionid).
        originAccountId(origin.getOriginAccountId()).destinationAccountId(destination.getDestinationAccountId()).
        originBalance(origin.getAccountBalance()).destinationBalance(destination.getAccountBalance()).
        transactionAmount(transactionRequest.getTransactionAmount()).
        transactionDate(now).transactionType(transactionRequest.getTransactionType()).build();


        persistTransactiontable(transactionresponse, origin, destination);

        return transactionresponse;
    }

    @Transactional
    private void persistTransactiontable(
            TransactionResponse transactionresponse, OriginAccount origin, DestinationAccount destination) {
                Transaction transaction= Transaction.builder().transactionId(transactionresponse.getTransactionId()).
                originAccount(origin).destinationAccount(destination).amount(transactionresponse.getTransactionAmount()).
                transactionDate(transactionresponse.getTransactionDate()).transactionType(transactionresponse.getTransactionType()).build();
                transactionRepository.save(transaction);
    }

    @Transactional
    public List<Transaction> getTransactionsbyAccount(Iterable<Integer> id) {
        return transactionRepository.findAllById(id);
    }

    @Transactional
    public Flux<Transaction> getAllTransactions(){


            return (Flux<Transaction>) transactionRepository.findAll();


    }



}

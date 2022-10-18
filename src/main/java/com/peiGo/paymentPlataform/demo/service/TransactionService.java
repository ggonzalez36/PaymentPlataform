package com.peiGo.paymentPlataform.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peiGo.paymentPlataform.model.entity.OriginAccount;
import com.peiGo.paymentPlataform.model.repository.DestinationAccountRepository;
import com.peiGo.paymentPlataform.model.repository.OriginAccountRepository;
import com.peiGo.paymentPlataform.model.repository.TransactionRepository;
import com.peiGo.paymentPlataform.model.request.TransactionRequest;
import com.peiGo.paymentPlataform.model.response.TransactionResponse;

import javax.transaction.Transactional;
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
                return TransactionResponse.setMessage("the account does not exist");
            }
        }catch (Exception e){
            throw e;
        }
    }


    private TransactionResponse createTransaction(TransactionRequest transactionRequest) {

        

        TransactionResponse transactionresponse= TransactionResponse.builder().build();



}

package com.peiGo.paymentPlataform.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.peiGo.paymentPlataform.demo.model.entity.DestinationAccount;
import com.peiGo.paymentPlataform.demo.model.entity.OriginAccount;
import com.peiGo.paymentPlataform.demo.model.repository.OriginAccountRepository;
import com.peiGo.paymentPlataform.demo.model.repository.DestinationAccountRepository;

public class AccountService {

    @Autowired
    private OriginAccountRepository originrepo;

    @Autowired
    private DestinationAccountRepository destinationrepo;

    public String createoriginAccount(OriginAccount origin) {
        try {
            if (!originrepo.existsById(origin.getAccountId())){
                origin.setAccountId(null == originrepo.findMaxId()? 0 : originrepo.findMaxId() + 1);
                originrepo.save(origin);
                return "origin Account record created successfully.";
            }else {
                return "origin Account already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

    public String createdestinationAccount(DestinationAccount destination) {
        try {
            if (!destinationrepo.existsById(destination.getAccountId())){
                destination.setAccountId(null == destinationrepo.findMaxId()? 0 : destinationrepo.findMaxId() + 1);
                destinationrepo.save(destination);
                return "destination Account record created successfully.";
            }else {
                return "destination Account already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }
    
}

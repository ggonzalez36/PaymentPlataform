package com.peiGo.paymentPlataform.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.peiGo.paymentPlataform.demo.model.entity.Client;
import com.peiGo.paymentPlataform.demo.model.repository.ClientRepository;



@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    @Transactional
    public String createClient(Client client) {
        try {
            if (!clientRepo.existsById(client.getClientId())){
            client.setClientId(null == clientRepo.findMaxId()? 0 : clientRepo.findMaxId() + 1);

                clientRepo.save(client);
                return "Client created successfully.";
            }else {
                return "Client already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }

}

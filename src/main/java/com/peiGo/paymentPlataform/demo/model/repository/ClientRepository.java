package com.peiGo.paymentPlataform.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peiGo.paymentPlataform.demo.model.entity.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Client findByclientId(int id);

    @Query("select max(c.clientId) from Client c")
    public Integer findMaxId();
}

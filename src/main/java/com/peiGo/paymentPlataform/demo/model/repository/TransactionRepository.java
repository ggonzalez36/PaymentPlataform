package com.peiGo.paymentPlataform.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peiGo.paymentPlataform.demo.model.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    public Transaction findBytransactionId(int id);

    @Query("select max(t.transactionId) from Transaction t")
    public Integer findMaxId();

}


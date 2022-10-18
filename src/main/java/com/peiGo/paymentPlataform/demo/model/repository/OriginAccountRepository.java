package com.peiGo.paymentPlataform.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peiGo.paymentPlataform.demo.model.entity.OriginAccount;



@Repository
public interface OriginAccountRepository extends JpaRepository<OriginAccount, Integer> {

    public OriginAccount findByaccountId(int id);

    @Query("select max(a.accountId) from Account a")
    public Integer findMaxId();
}

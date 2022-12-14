package com.peiGo.paymentPlataform.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peiGo.paymentPlataform.demo.model.entity.DestinationAccount;



@Repository
public interface DestinationAccountRepository extends JpaRepository<DestinationAccount, Integer> {

    public DestinationAccount findByDestinationAccountId(int id);

    @Query("select max(da.destinationAccountId) from DestinationAccount da")
    public Integer findMaxId();
}

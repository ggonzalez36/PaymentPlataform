package com.peiGo.paymentPlataform.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.peiGo.paymentPlataform.demo.entity.OriginAccount;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<OriginAccount, Integer> {

    public boolean existsByEmail(String email);

    public List<OriginAccount> findByEmail(String email);

    @Query("select max(a.accountId) from Account a")
    public Integer findMaxId();
}

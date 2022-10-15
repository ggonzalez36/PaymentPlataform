package com.peiGo.paymentPlataform.demo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List; 


@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@Table(name ="destinationAccount")
public class DestinationAccount {

    @Id
    @Column(name="accountId")
    private int accountId;

    private BigDecimal accountBalance;

    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    private Date lastUpdate;

    @OneToMany(mappedBy = "destinationAccount")
    private List <Transaction> transactions;

    public DestinationAccount() {
    }
    
}

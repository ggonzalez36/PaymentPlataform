package com.peiGo.paymentPlataform.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@Table(name ="transaction")
public class Transaction {

    @Id
    private int transactionId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="originAccount_ID")
    private OriginAccount originAccount;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="destinationAccount_ID")
    private DestinationAccount destinationAccount;

    private BigDecimal amount;

    private Date transactionDate;
    
    private String transactionType;
    
}

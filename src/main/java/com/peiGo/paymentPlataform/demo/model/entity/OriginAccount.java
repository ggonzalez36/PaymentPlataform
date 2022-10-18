package com.peiGo.paymentPlataform.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import javax.persistence.Table;



@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@Table(name ="originAccount")
public class OriginAccount {

    @Id
    @Column(name="accountId")
    private int originAccountId;

    private BigDecimal accountBalance;

    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    private Date lastUpdate;

    // @OneToMany(mappedBy = "originAccount")
    // private List <Transaction> transactions;

    public OriginAccount() {
    }

}

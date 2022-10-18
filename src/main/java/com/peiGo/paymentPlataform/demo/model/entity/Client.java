package com.peiGo.paymentPlataform.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Table;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@Table(name ="client")
public class Client {

    @Id
    @Column(name = "clientId")
    private  int clientId;

    @OneToOne(fetch=FetchType.LAZY, mappedBy="client")
    private OriginAccount account;

    private String firstName;

    private String LastName;
    
    private Date CreationDate;

    private Date LastUpdate; 
    
}

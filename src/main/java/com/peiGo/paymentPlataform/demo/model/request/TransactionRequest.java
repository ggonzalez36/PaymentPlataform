package com.peiGo.paymentPlataform.demo.model.request;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@ToString
@Builder
@AllArgsConstructor
public class TransactionRequest {


    @JsonProperty("originAccountId")
    private int originAccountId;

    @JsonProperty("destinationAccountId")
    private int destinationAccountId;

    @JsonProperty("transactionAmount")
    private BigDecimal transactionAmount;

    @JsonProperty("transactionType")
    private String transactionType;


    
}

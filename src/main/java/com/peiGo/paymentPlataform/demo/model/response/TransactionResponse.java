package com.peiGo.paymentPlataform.demo.model.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;


@Data
@ToString
@Builder
@AllArgsConstructor
public class TransactionResponse {

    @JsonProperty("transactionId")
    private int transactionId;

    @JsonProperty("originAccountId")
    private int originAccountId;

    @JsonProperty("destinationAccountId")
    private int destinationAccountId;

    @JsonProperty("transactionAmount")
    private BigDecimal transactionAmount;

    @JsonProperty("originBalance")
    private BigDecimal originBalance;

    @JsonProperty("destinationBalance")
    private BigDecimal destinationBalance;

    @JsonProperty("transactionDate")
    private Date transactionDate;

    @JsonProperty("transactionType")
    private String transactionType;

}

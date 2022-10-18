package com.peiGo.paymentPlataform.demo.model.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class JwtResponse {
   
    private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
}

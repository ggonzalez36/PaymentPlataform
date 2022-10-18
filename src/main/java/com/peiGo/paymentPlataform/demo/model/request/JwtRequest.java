package com.peiGo.paymentPlataform.demo.model.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class JwtRequest {

    private static final long serialVersionUID = 5926468583005150707L;
	
	private String username;
	private String password;

	public JwtRequest(){}
    
}

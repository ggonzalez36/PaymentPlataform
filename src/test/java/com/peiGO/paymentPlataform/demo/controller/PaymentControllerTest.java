package com.peiGO.paymentPlataform.demo.controller;


import org.mockito.Mock;
import com.peiGo.paymentPlataform.demo.service.AccountService;
import com.peiGo.paymentPlataform.demo.service.ClientService;
import com.peiGo.paymentPlataform.demo.service.TransactionService;
import com.peiGo.paymentPlataform.demo.controller.PaymentController;
import com.peiGo.paymentPlataform.demo.model.entity.Client;


import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class PaymentControllerTest {

    private  PaymentController controller;

    @Mock
    private TransactionService transactionService;

    @Mock
    private AccountService accountService;

    @Mock
    private ClientService clientService;

    @Mock
    private Client client=Client.builder().clientId(1).firstName("Paul").build();

    @Before
    public  void init(){
        clientService= mock(ClientService.class);
        controller = new PaymentController(transactionService,accountService,clientService);

        
    
    }

    
    @Test
    public void testcreateOriginSuccess(){
        String response1=clientService.createClient(client);
        String response=controller.createClient(client);
    
        assertEquals(response1,response);

    }

    
}

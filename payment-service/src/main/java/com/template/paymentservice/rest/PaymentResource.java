package com.template.postservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/payment")
public class PaymentResource {


  @GetMapping(value = "/getPaymentById")
  public String getPaymentById(){
    return "Payment";
  }


}

package com.template.billingservice.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/Billing")
public class BillingResource {


  @GetMapping(value = "/getBillingById")
  public String getBillingById(){
    return "Billing";
  }


}

package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Patent {

    @Id
    public String id;
    public String applicationNumber;
    public String description;
    public Date filingDate;
    //required
    public String inventors;
    public String memberId;
    public String name;
    public Date issueDate;
    //required
    public String issuer;
    public String number;
    //required
    public String pending;
    //required
    public String title;
    public String url;




}

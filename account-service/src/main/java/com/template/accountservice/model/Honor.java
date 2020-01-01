package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
public class Honor extends BaseEntity {

    @Id
    public UUID id;
    public String description;
    public Date issueDate;
    public String issuer;
    public String occupation;
    //required
    public String title;




}

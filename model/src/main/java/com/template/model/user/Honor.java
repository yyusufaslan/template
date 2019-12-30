package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
public class Honor {

    @Id
    public UUID id;
    public Map<String,String> description;
    public Date issueDate;
    public String issuer;
    public String occupation;
    //required
    public String title;




}

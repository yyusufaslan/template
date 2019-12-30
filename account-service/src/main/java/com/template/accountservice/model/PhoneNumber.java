package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class PhoneNumber {
    @Id
    public UUID id;
    public String number;
    //Enum WORK HOME MOBILE
    public String type;


}

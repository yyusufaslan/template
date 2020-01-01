package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Locale extends BaseEntity {

    @Id
    public UUID id;
    //An uppercase two-letter country code as defined by  ISO-3166 .
    public String country;
    //A lowercase two-letter language code as defined by  ISO-639 .
    public String language;
    /*
    "locale":{
      "country":"US",
      "language":"en"
    }
    */
}

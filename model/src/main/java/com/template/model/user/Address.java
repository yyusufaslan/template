package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Address {

  @Id
  public UUID id;
  public String localized;
  public String preferredLocale;

/*
   "address":{
      "localized":{
         "en_US":"2029 Stierlin Ct, Mountain View, CA 94043"
      },
      "preferredLocale":{
         "country":"US",
         "language":"en"
      }
   }
*/
}

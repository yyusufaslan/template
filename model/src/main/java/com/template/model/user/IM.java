package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class IM {


  @Id
  public UUID id;
  //required
  public String provider;


}

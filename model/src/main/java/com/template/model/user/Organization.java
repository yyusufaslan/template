package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
public class Organization {

  @Id
  public UUID id;
  public String description;
  public Date endMonthYear;
  public String name;
  public String occupation;
  public String position;
  public Date startMonthYear;
}

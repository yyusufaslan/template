package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Certification {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public UUID id;
  public String authority;
  public String company;
  public Date endMonthYear;
  public String licenseNumber;
  public String name;
  public Date startMonthYear;
  public String url;
}

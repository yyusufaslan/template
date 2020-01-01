package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class VolunteeringExperience {

  @Id
  public UUID id;
  //Cause of the volunteering experience represented in predefined string. Enum of predefined volunteering causes:
  //animalRights
  //artsAndCulture
  //children
  //civilRights
  //economicEmpowerment
  //education
  //environment
  //health
  //humanRights
  //humanitarianRelief
  //politics
  //povertyAlleviation
  //scienceAndTechnology
  //socialServices
  public String cause;
  public String company;
  //required
  public String companyName;
  public String description;
  public Date endMonthYear;
  //required Localizable duty or responsibility performed at this volunteering experience. I
  public String role;
  //A boolean that distinguishes between an ongoing volunteering experience without an end date and a volunteering experience that occurred at one specofic time.
  public boolean singleDate;
  public Date startMonthYear;
}

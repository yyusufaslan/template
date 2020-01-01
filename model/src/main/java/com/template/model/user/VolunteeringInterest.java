package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class VolunteeringInterest {
  @Id
  public UUID id;
  public String supportedNonprofits;
  public String companyId;
  //required
  public String companyName;
  //An array of enum. Enum of predefined volunteering causes:
    /*animalRights
    artsAndCulture
    children
    civilRights
    economicEmpowerment
    education
    environment
    health
    humanRights
    humanitarianRelief
    politics
    povertyAlleviation
    scienceAndTechnology
    socialServices
    */
  public String supportedPredefinedCauses;
  /*An array of user inputted string. Not currently used in any LinkedIn platform's UI.*/
  public String supportedUserDefinedCauses;
}

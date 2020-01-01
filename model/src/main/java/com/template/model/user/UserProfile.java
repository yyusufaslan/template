package com.template.model.user;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class UserProfile {

  @Id
  public UUID id;
  @Column
  public Address address;
  public String associations;
  //public BackgroundImage backgroundImage;
  public Date birthDate;
  public Certification certifications;
  public String contactInstructions;
  public Course courses;
  public Education educations;
  public Honor honors;
  public IM ims;
  public Language languages;
  public String legacyHonors;
  //Single Married
  public Enum maritalStatus;
  public Organization organizations;
  public Patent patents;
  public PhoneNumber phoneNumbers;
  public Project projects;
  public Publication publications;
  public Skill skills;
  public Locale supportedLocales;
  public TestScore testScores;
  public VolunteeringExperience volunteeringExperiences;
  public VolunteeringInterest volunteeringInterests;
  public Website websites;


}

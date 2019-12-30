package com.template.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class UserProfile {

    @Id
    public UUID id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("address")
    public Address address;
    public String associations;
    //public BackgroundImage backgroundImage;
    public Date birthDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    @JsonProperty("certifications")
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

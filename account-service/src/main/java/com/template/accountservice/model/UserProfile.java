package com.template.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class UserProfile extends BaseEntity {

    @Id
    public UUID id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("address")
    public Address address;
    public String associations;
    //public BackgroundImage backgroundImage;
    public Date birthDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "certification_id")
    @JsonProperty("certification")
    private List<Certification> certification;

    public String contactInstructions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    public List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    public List<Education> educations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    public List<Honor> honors;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_id")
    @JsonProperty("course")
    public List<IM> ims;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "language_id")
    @JsonProperty("language")
    public List<Language> languages;

    public String legacyHonors;
    //Single Married
    public Enum maritalStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "organization_id")
    @JsonProperty("organization")
    public List<Organization> organizations;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "patent_id")
    @JsonProperty("patent")
    public List<Patent> patents;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "phoneNumber_id")
    @JsonProperty("phoneNumber")
    public List<PhoneNumber> phoneNumbers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_id")
    @JsonProperty("project")
    public List<Project> projects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "publication_id")
    @JsonProperty("publication")
    public List<Publication> publications;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "skill_id")
    @JsonProperty("skill")
    public List<Skill> skills;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "supportedLocale_id")
    @JsonProperty("supportedLocale")
    public List<Locale> supportedLocales;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "testScore_id")
    @JsonProperty("testScore")
    public List<TestScore> testScores;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "volunteeringExperience_id")
    @JsonProperty("volunteeringExperience")
    public List<VolunteeringExperience> volunteeringExperiences;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "volunteeringInterest_id")
    @JsonProperty("volunteeringInterest")
    public List<VolunteeringInterest> volunteeringInterests;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "website_id")
    @JsonProperty("website")
    public List<Website> websites;







}

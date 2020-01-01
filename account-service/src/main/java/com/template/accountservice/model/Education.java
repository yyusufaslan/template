package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Education extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String activities;
    public String degreeName;
    public Date endMonthYear;
    public String fieldsOfStudy;
    public String fieldOfStudyName;
    public String grade;
    public String localGrade;
    public String notes;
    public String program;
    //public RichMediaAssociations richMediaAssociations;
    public String school;
    public String schoolName;
    public Date startMonthYear;


}

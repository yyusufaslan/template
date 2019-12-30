package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Project {

    @Id
    public UUID id;
    public String description;
    public Date endMonthYear;
    //Required
    //People who contributed to the project. Represented in an array of Contributors. Required to have the member's own person URN in the array.
    public String members;
    public String memberId;
    public String name;
    //Position a member held while working on this project. Selected from a position of the member's profile. Represented as either a standardized referenced company or school URN.
    public String occupation;
    //A boolean that distinguishes between an ongoing project without an end date and a project that occurred at one specofic time.
    public Boolean singleDate;
    public Date startMonthYear;
    //Required
    public String title;
    public String url;

}

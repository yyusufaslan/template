package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class TestScore {
    @Id
    public UUID id;
    public Date date;
    public String description;
    //required
    public String name;
    //Position a member held while during this test. Selected from a position of the member's profile. Represented as either a standardized referenced company or school URN
    public String occupation;
    //Score achieved on the test represented in string.
    public String score;

}

package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Website {
    @Id
    public UUID id;
    /*
    Enum of predefined volunteering causes:
    PERSONAL
    COMPANY
    BLOG
    RSS
    PORTFOLIO
    OTHER*/
    public String category;
    //Localizable label a member chose for a website in "OTHER" category. I
    public String label;
    //required
    public String url;
}

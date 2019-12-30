package com.template.model.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Publication {

    @Id
    public UUID id;
    //People who wrote the publication or contributed to it. Represented in an array of Contributors. Required to have the member's own person URN in the array.
    public String authors;
    public String memberId;
    //Localizable member name.
    public String name;
    public Date date;
    public String description;
    //Localizable name of the publication
    public String publicationName;
    public String publisher;
    public String url;

}

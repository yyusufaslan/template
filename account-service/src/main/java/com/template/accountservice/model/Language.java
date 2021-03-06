package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class Language extends BaseEntity {
    @Id
    public UUID id;
    //required
    public String name;
    public String proficiency;
}

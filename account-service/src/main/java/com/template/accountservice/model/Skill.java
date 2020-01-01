package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Skill extends BaseEntity {

    @Id
    public String id;
    //required localizable skill name as defined by the member.
    public String name;
}

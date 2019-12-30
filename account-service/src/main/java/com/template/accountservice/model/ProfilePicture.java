package com.template.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class ProfilePicture {
    @Id
    public UUID id;
    //An epoch timestamp corresponding to the creation of the picture. Represented in milliseconds. This field requires special permissions available only to select partners.
    //auduting
    public Timestamp created;
    //An epoch timestamp corresponding to the deletion of the picture. Represented in milliseconds. Optional. This field requires special permissions available only to select partners.
    public Timestamp deleted;
    //An epoch timestamp corresponding to the last modification of the picture. Represented in milliseconds. This field requires special permissions available only to select partners.
    public String displayImage;
    public Timestamp lastModified;
    //The digitalmediaAsset URN of the original image. Will only appear in self-view. This field requires special permissions available only to select partners
    public String originalImage;
    //Optional information object on the photo filter operations applied to the profile picture. This field requires special permissions available only to select partners.
    public String photoFilterEditInfo;

}

package com.template.accountservice.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity implements Serializable {

  private final static long serialVersionUID = 1L;

  @CreatedDate
  @JsonIgnore
  private LocalDateTime createDate;

  @LastModifiedDate
  @JsonIgnore
  private LocalDateTime updateDate;

  @CreatedBy
  @JsonIgnore
  private String createdBy;

  @LastModifiedBy
  @JsonIgnore
  private String lastModifiedBy;

  @JsonIgnore
  private LocalDateTime endDate;

}

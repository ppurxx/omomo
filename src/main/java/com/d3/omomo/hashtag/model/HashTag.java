package com.d3.omomo.hashtag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="hash_tag")
public class HashTag {
  @Id
  @Column(name="hash_tag_name", nullable = false)
  String hashTagName;
}

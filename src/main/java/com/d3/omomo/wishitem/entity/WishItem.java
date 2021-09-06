package com.d3.omomo.wishitem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wish_item")
public class WishItem {
    @Id
    private String wishItemNo;
    private String userId;
    private String wishItemText;
    private boolean wishItemCompletion;
    private Instant modifiedDateTime;
}

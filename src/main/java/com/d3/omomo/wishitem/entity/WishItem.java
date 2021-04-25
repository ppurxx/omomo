package com.d3.omomo.wishitem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WishItem {
    private String wishItemNo;
    private String userId;
    private String wishItemText;
    private String wishItemCompletion;
    private Instant modifiedDatetime;
}

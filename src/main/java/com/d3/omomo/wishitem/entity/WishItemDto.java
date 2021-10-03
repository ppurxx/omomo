package com.d3.omomo.wishitem.entity;

import com.d3.omomo.hashtag.model.HashTag;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WishItemDto {
  private String userId;
  private String wishItemText;
  private boolean wishItemCompletion;
  private Instant modifiedDateTime;
  private List<HashTag> hashTagList;

  public WishItem toEntity(){
    return new WishItem(userId, wishItemText, wishItemCompletion, Instant.now(), hashTagList);
  }
}

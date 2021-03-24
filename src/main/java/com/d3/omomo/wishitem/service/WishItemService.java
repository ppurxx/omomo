package com.d3.omomo.wishitem.service;

import com.d3.omomo.wishitem.entity.WishItem;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WishItemService {
    List<WishItem> getWishItemList(String userId);
    int createWishItem(WishItem wishItem);
    int updateWishItem(WishItem wishItem);
    int updateWishItemToCompletion(WishItem wishItem);
    int deleteWishItem(String wishItemNo);
}

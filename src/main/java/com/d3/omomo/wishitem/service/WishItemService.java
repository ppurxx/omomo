package com.d3.omomo.wishitem.service;

import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.entity.WishItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WishItemService {
    List<WishItem> getWishItemList(String userId, int pageNumber);
    WishItem createWishItem(WishItemDto wishItemDto);
    int updateWishItem(WishItemDto wishItemDto);
    int updateWishItemToCompletion(WishItemDto wishItemDto);
    int deleteWishItem(String wishItemNo);
}

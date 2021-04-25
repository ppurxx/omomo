package com.d3.omomo.wishitem.service;

import com.d3.omomo.wishitem.entity.WishItem;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WishItemServiceImpl implements WishItemService{
    @Override
    public List<WishItem> getWishItemList(String userId) {
        return Collections.emptyList();
    }

    @Override
    public int createWishItem(WishItem wishItem) {
        return 0;
    }

    @Override
    public int updateWishItem(WishItem wishItem) {
        return 0;
    }

    @Override
    public int updateWishItemToCompletion(WishItem wishItem) {
        return 0;
    }

    @Override
    public int deleteWishItem(String wishItemNo) {
        return 0;
    }
}

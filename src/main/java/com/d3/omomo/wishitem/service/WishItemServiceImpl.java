package com.d3.omomo.wishitem.service;

import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.repository.WishItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WishItemServiceImpl implements WishItemService{
    private final WishItemRepository wishItemRepository;
    @Override
    public List<WishItem> getWishItemList(String userId) {
        return Collections.emptyList();
    }

    @Override
    public WishItem createWishItem(WishItem wishItem) {
        return wishItemRepository.save(wishItem);
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

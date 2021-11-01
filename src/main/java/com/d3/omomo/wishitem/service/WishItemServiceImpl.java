package com.d3.omomo.wishitem.service;

import com.d3.omomo.hashtag.service.HashtagService;
import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.entity.WishItemDto;
import com.d3.omomo.wishitem.repository.WishItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishItemServiceImpl implements WishItemService{
    private final WishItemRepository wishItemRepository;
    private final HashtagService hashtagService;
    @Override
    public List<WishItem> getWishItemList(String userId, int pageNumber) {
        return wishItemRepository.findAllByUserId(userId, PageRequest
            .of(pageNumber, 10, Sort.by(Sort.Direction.DESC, "modifiedDateTime")));
    }

    @Override
    public WishItem createWishItem(WishItemDto wishItemDto) {
        hashtagService.saveHashtagList(wishItemDto.getHashTagList());
        return wishItemRepository.save(wishItemDto.toEntity());
    }

    @Override
    public int updateWishItem(WishItemDto wishItemDto) {
        return 0;
    }

    @Override
    public int updateWishItemToCompletion(WishItemDto wishItemDto) {
        return 0;
    }

    @Override
    public int deleteWishItem(String wishItemNo) {
        return 0;
    }
}

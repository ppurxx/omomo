package com.d3.omomo.wishitem;


import static org.mockito.Mockito.when;

import com.d3.omomo.hashtag.model.HashTag;
import com.d3.omomo.hashtag.repository.HashTagRepository;
import com.d3.omomo.wishitem.controller.WishItemController;
import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.entity.WishItemDto;
import com.d3.omomo.wishitem.repository.WishItemRepository;
import com.d3.omomo.wishitem.service.WishItemService;
import com.d3.omomo.wishitem.service.WishItemServiceImpl;
import com.google.common.collect.ImmutableList;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@SpringBootTest
@Transactional
@RequiredArgsConstructor
public class WishItemTest {

  @Autowired WishItemRepository wishItemRepository;
  @Autowired HashTagRepository hashTagRepository;
  @Autowired WishItemController wishItemController;
  @Autowired WishItemServiceImpl wishItemService;

  @DisplayName("wish item 입력 테스트")
  public void test(){

    hashTagRepository.saveAll(ImmutableList.of(new HashTag("#test3")));
    wishItemRepository.save(
        new WishItem(3,"3","test",true, Instant.now(), ImmutableList.of(new HashTag("#test3")))
    );
  }


  @DisplayName("wish item creation test without hashtag")
  public void testInputWishItem(){
    WishItemDto wishItemDto = new WishItemDto("nick.sh","테스트",false,Instant.now(),null);
    wishItemController.createWishItem(wishItemDto);
  }

  @DisplayName("wish item creation test without hashtag")
  public void testInputWishItemWithHashTagList(){
    WishItemDto wishItemDto = new WishItemDto("nick.sh","테스트",false,Instant.now(),ImmutableList.of(new HashTag("#test1"),new HashTag("#test2"),new HashTag("#test3")));
    wishItemController.createWishItem(wishItemDto);
  }

  @DisplayName("retrieve wish item with hashtag list by user id ")
  @Test
  public void testRetreiveWishItemList(){
    List<WishItem> resultList = wishItemService.getWishItemList("nick");
  }

  public void test2(){
    log.info(String.valueOf(StringUtils.startsWithIgnoreCase("010010010","010")));
  }
}

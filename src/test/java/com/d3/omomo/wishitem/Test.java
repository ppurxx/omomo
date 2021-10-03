package com.d3.omomo.wishitem;


import com.d3.omomo.hashtag.model.HashTag;
import com.d3.omomo.hashtag.repository.HashTagRepository;
import com.d3.omomo.wishitem.controller.WishItemController;
import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.entity.WishItemDto;
import com.d3.omomo.wishitem.repository.WishItemRepository;
import com.google.common.collect.ImmutableList;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
@SpringBootTest
@Transactional
public class Test {
  @Autowired
  WishItemRepository wishItemRepository;

  @Autowired
  HashTagRepository hashTagRepository;

  @Autowired
  WishItemController wishItemController;

  @DisplayName("wish item 입력 테스트")
  @org.junit.jupiter.api.Test
  public void test(){

    hashTagRepository.saveAll(ImmutableList.of(new HashTag("#test3")));
    wishItemRepository.save(
        new WishItem(3,"3","test",true, Instant.now(), ImmutableList.of(new HashTag("#test3")))
    );
  }


  @DisplayName("wish item creation test without hashtag")
  @org.junit.jupiter.api.Test
  public void testInputWishItem(){
    WishItemDto wishItemDto = new WishItemDto("nick.sh","테스트",false,Instant.now(),null);
    wishItemController.createWishItem(wishItemDto);
  }

  @DisplayName("wish item creation test without hashtag")
  @org.junit.jupiter.api.Test
  public void testInputWishItemWithHashTagList(){
    WishItemDto wishItemDto = new WishItemDto("nick.sh","테스트",false,Instant.now(),ImmutableList.of(new HashTag("#test1"),new HashTag("#test2"),new HashTag("#test3")));
    wishItemController.createWishItem(wishItemDto);
  }

  @org.junit.jupiter.api.Test
  public void test2(){
    log.info(String.valueOf(StringUtils.startsWithIgnoreCase("010010010","010")));
  }
}

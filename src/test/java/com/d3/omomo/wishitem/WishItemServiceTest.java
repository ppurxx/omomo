package com.d3.omomo.wishitem;

import com.d3.omomo.hashtag.model.HashTag;
import com.d3.omomo.wishitem.entity.WishItemDto;
import com.d3.omomo.wishitem.service.WishItemServiceImpl;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;


//@@TODO turn to slicing test
@SpringBootTest
public class WishItemServiceTest {
  WishItemServiceImpl wishItemService;
  public WishItemServiceTest(WishItemServiceImpl wishItemService){
    this.wishItemService = wishItemService;
  }

  final static String TEST_USER_ID = "nick.sh";
  final static String TEST_WISH_ITEM_TEXT = "TEST_WISH_ITEM_TEXT";
  final static boolean TEST_WISH_ITEM_COMPLETION = false;
  final static List<HashTag> TEST_HASH_TAG_LIST = Arrays.asList(
      new HashTag("TEST_HASHTAG_1"),
      new HashTag("TEST_HASHTAG_2"),
      new HashTag("TEST_HASHTAG_3")
  );
  final static WishItemDto TEST_TARGET_OF_WISH_ITEM_DTO = new WishItemDto(
      TEST_USER_ID,
      TEST_WISH_ITEM_TEXT,
      TEST_WISH_ITEM_COMPLETION,
      Instant.now(),
      TEST_HASH_TAG_LIST
  );

  @Before
  public void initTest(){
//    when(wishItemService.getWishItemList(TEST_USER_ID, 0)).thenReturn()
  }


}

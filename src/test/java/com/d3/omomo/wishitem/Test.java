package com.d3.omomo.wishitem;


import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.repository.WishItemRepository;
import java.time.Instant;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
  @Autowired
  WishItemRepository wishItemRepository;

  @DisplayName("wish item 입력 테스트")
  @org.junit.jupiter.api.Test
  public void test(){
    wishItemRepository.save(
        new WishItem("1","1","test",true, Instant.now())
    );
  }
}

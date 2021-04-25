package com.d3.omomo.wishlist.controller;

import com.d3.omomo.wishlist.model.WishItem;
import com.d3.omomo.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class wishListController {
  private final WishListService wishListService;

  @RequestMapping("/api/v1/wishitem")
  public void saveWishitem(@RequestBody WishItem wishItem){
    wishListService.saveWishitem(wishItem);

  }

}

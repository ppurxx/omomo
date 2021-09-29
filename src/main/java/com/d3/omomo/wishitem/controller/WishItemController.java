package com.d3.omomo.wishitem.controller;

import com.d3.omomo.wishitem.entity.WishItem;
import com.d3.omomo.wishitem.entity.WishItemDto;
import com.d3.omomo.wishitem.service.WishItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

import static com.d3.omomo.common.config.Const.*;

@Api(value = API_PREFIX + "/wishitem", consumes = "application/json")
@RestController
@RequestMapping(API_PREFIX + "/wishitem")
public class WishItemController {
    final Logger L = LoggerFactory.getLogger(this.getClass());

    WishItemService wishItemService;

    public WishItemController(WishItemService wishItemService) {
        this.wishItemService = wishItemService;
    }

    @ApiOperation(httpMethod = GET_METHOD, value = "wish item 전부 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<List<WishItem>> getWishItemList(@PathVariable String userId) {
        L.debug("[{}] /api/v1/wishitem/{}", GET_METHOD, userId);
        return ResponseEntity.ok(wishItemService.getWishItemList(userId));
    }

    @ApiOperation(httpMethod = POST_METHOD, value = "wish item 저장", produces = "application/json", consumes = "application/json")
    @PostMapping
    public ResponseEntity<WishItem> createWishItem(@RequestBody WishItemDto wishItemDto) {
        L.debug("[{}] /api/v1/wishitem/", POST_METHOD);
        return ResponseEntity.ok(wishItemService.createWishItem(wishItemDto));
    }

    @ApiOperation(httpMethod = PATCH_METHOD, value = "wish item 수정 (텍스트, 해시태그)", produces = "application/json", consumes = "application/json")
    @PatchMapping
    public ResponseEntity<Integer> updateWishItem(@RequestBody WishItemDto wishItemDto) {
        L.debug("[{}] /api/v1/wishitem/", PATCH_METHOD);
        return ResponseEntity.ok(wishItemService.updateWishItem(wishItemDto));
    }

    @ApiOperation(httpMethod = PATCH_METHOD, value = "wish item 완료처리", produces = "application/json", consumes = "application/json")
    @PatchMapping("/completion")
    public ResponseEntity<Integer> updateWishItemToCompletion(@RequestBody WishItemDto wishItemDto) {
        L.debug("[{}] /api/v1/wishitem/completion", POST_METHOD);
        return ResponseEntity.ok(wishItemService.updateWishItem(wishItemDto));
    }

    @ApiOperation(httpMethod = DELETE_METHOD, value = "wish item 삭제", produces = "application/json", consumes = "application/json")
    @DeleteMapping("/{wishItemNo}")
    public ResponseEntity<Integer> deleteWishItem(@PathVariable String wishItemNo) {
        L.debug("[{}] /api/v1/wishitem/{}", DELETE_METHOD, wishItemNo);
        return ResponseEntity.ok(wishItemService.deleteWishItem(wishItemNo));
    }
}

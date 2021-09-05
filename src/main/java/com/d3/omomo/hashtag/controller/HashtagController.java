package com.d3.omomo.hashtag.controller;

import com.d3.omomo.hashtag.repository.HashTagRepository;
import com.d3.omomo.hashtag.service.HashtagService;
import com.d3.omomo.hashtag.model.HashTag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HashtagController {
  public final HashtagService hashtagService;
  @RequestMapping("/api/v1/hashtag")
  public List<HashTag> getHashtagList(@RequestParam String searchHashtagKeyword){
    return hashtagService.getHashtagListByKeyword(searchHashtagKeyword);
  }
}

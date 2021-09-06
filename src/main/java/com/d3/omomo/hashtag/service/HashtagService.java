package com.d3.omomo.hashtag.service;

import com.d3.omomo.hashtag.model.HashTag;
import com.d3.omomo.hashtag.repository.HashTagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HashtagService {
  private final HashTagRepository hashTagRepository;

  public List<HashTag> getHashtagListByKeyword(String searchHashtagKeyword){
    return hashTagRepository.findByHashTagNameStartsWith(searchHashtagKeyword);
  }


}

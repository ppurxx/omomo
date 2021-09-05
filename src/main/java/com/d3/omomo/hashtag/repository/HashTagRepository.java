package com.d3.omomo.hashtag.repository;

import com.d3.omomo.hashtag.model.HashTag;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepository extends JpaRepository<HashTag,String> {
  public List<HashTag> findByHashTagNameStartsWith(String keyword);
}

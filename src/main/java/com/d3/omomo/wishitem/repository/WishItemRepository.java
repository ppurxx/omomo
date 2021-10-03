package com.d3.omomo.wishitem.repository;

import com.d3.omomo.wishitem.entity.WishItem;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishItemRepository extends JpaRepository<WishItem, String> {
  public List<WishItem> findAllByUserId(String userId, Sort sort);
}

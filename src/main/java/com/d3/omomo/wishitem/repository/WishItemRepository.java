package com.d3.omomo.wishitem.repository;

import com.d3.omomo.wishitem.entity.WishItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishItemRepository extends JpaRepository<WishItem, String> {

}

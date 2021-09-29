package com.d3.omomo.wishitem.entity;

import com.d3.omomo.hashtag.model.HashTag;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="wish_item")
public class WishItem {
    @Id
    @Column(name="wish_item_no")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long wishItemNo;

    private String userId;
    private String wishItemText;
    private boolean wishItemCompletion;
    private Instant modifiedDateTime;

    @ManyToMany
    @JoinTable(name="wish_item_hash_tag",
    joinColumns = @JoinColumn(name="wish_item_no"),
    inverseJoinColumns = @JoinColumn(name="hash_tag_name")
    )
    private List<HashTag> hashTagList;

    public WishItem(String userId, String wishItemText, boolean wishItemCompletion, Instant modifiedDateTime, List<HashTag> hashTagList){
        this.userId = userId;
        this.wishItemText = wishItemText;
        this.wishItemCompletion = wishItemCompletion;
        this.modifiedDateTime = modifiedDateTime;
        this.hashTagList = hashTagList;
    }
}

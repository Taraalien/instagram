package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.common.base.BaseEntity;
import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Like extends BaseEntity {

    @NotNull
    @Column(name = "like")
    private LikeType likeType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}

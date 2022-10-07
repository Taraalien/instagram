package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.common.base.BaseEntity;
import com.kurdsoft.instagram.like.LikeType;
import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_comment")
@Data
@Audited
public class Comment extends BaseEntity {

    @NotNull
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}

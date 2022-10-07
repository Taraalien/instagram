package com.kurdsoft.instagram.post;

import com.kurdsoft.instagram.comment.Comment;
import com.kurdsoft.instagram.common.base.BaseEntity;
import com.kurdsoft.instagram.like.Like;
import com.kurdsoft.instagram.user.User;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Audited
@Table(name = "tbl_post")
public class Post extends BaseEntity {

    @NotNull
    @Column(name = "photo")
    private String photo;

    @NotNull
    @Column(name = "caption")
    private String caption;




    @OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "post",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

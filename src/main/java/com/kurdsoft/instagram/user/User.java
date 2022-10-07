package com.kurdsoft.instagram.user;

import com.kurdsoft.instagram.comment.Comment;
import com.kurdsoft.instagram.common.base.BaseEntity;
import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.following.Following;
import com.kurdsoft.instagram.like.Like;
import com.kurdsoft.instagram.post.Post;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
@Table(name = "tbl_user")
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "usrname")
    private String userName;

    @NotNull
    @Column(name = "phoneNumber")
    private String phoneNumber;


    @NotNull
    @Column(name = "gmailAcount")
    private String gmailAcount;

    @NotNull
    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Follower> followers;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Following> followings;
}

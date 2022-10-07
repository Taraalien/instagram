package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.like.Like;
import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends PagingAndSortingRepository<Comment,Long> {

    Page<Comment> findAll(Pageable pageable);

    List<Comment>findAllByPostId(Post post);
    List<Comment>findAllByUserId(User  user);
}
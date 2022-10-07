package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends PagingAndSortingRepository<Like,Long> {

    Page<Like> findAll(Pageable pageable);
    List<Like>findAllByUserId(User user);
    List<Like>findAllByPostId(Post post);
}

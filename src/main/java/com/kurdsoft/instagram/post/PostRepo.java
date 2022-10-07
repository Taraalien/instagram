package com.kurdsoft.instagram.post;


import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends PagingAndSortingRepository<Post,Long> {

    List<Post>findAllByUserId(User user);
    Page<Post> findAll(Pageable pageable);
}

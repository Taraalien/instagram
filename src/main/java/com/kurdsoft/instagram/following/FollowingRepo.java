package com.kurdsoft.instagram.following;

import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowingRepo extends PagingAndSortingRepository<Following,Long> {
    Page<Following> findAll(Pageable pageable);
    List<Following> findAllByUserId(User user);
}

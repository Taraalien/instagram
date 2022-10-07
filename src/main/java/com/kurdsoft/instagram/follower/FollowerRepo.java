package com.kurdsoft.instagram.follower;

import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepo extends PagingAndSortingRepository<Follower,Long> {
    Page<Follower> findAll(Pageable pageable);
    List<Follower> findAllByUserId(User user);
}

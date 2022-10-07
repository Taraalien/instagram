package com.kurdsoft.instagram.following;

import com.kurdsoft.instagram.follower.Follower;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IFollowingService {
    Following save(Following following);
    Following update(Following following);
    List<Following> getAll();
    void delete(Long id);
    Following getById(Long id);
    Page<Following> paging(Integer page, Integer size);
    List<Following>getByUserId(Long id);
}

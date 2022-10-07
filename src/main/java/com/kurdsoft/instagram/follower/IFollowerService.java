package com.kurdsoft.instagram.follower;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IFollowerService {

    Follower save(Follower follower);
    Follower update(Follower follower);
    List<Follower> getAll();
    void delete(Long id);
    Follower getById(Long id);
    Page<Follower> paging(Integer page, Integer size);
    List<Follower>getByUserId(Long id);
}

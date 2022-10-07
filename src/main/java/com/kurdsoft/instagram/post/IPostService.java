package com.kurdsoft.instagram.post;

import com.kurdsoft.instagram.user.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPostService {

    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
    Post getById(Long id);
    List<Post> getAll();
    List<Post> getByUserId(Long id);
    Page<Post> paging(Integer page, Integer size);
}

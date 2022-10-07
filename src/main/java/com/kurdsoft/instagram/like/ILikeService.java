package com.kurdsoft.instagram.like;


import com.kurdsoft.instagram.post.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ILikeService {


    Like save(Like like);
    Like update(Like like);
    void delete(Long id);
    Like getById(Long id);
    List<Like> getAll();
    List<Like> getByPostId(Long id);
    List<Like> getByUserId(Long id);
    Page<Like> paging(Integer page, Integer size);
}

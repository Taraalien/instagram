package com.kurdsoft.instagram.comment;


import com.kurdsoft.instagram.like.Like;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICommentService {


    Comment save(Comment comment);
    Comment update(Comment comment);
    void delete(Long id);
    Comment getById(Long id);
    List<Comment> getAll();
    List<Comment> getByPostId(Long id);
    List<Comment> getByUserId(Long id);
    Page<Comment> paging(Integer page, Integer size);
}

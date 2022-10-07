package com.kurdsoft.instagram.user;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    User save(User user);
    User update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();

    Page<User> paging(Integer page,Integer size);
}

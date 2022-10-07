package com.kurdsoft.instagram.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends PagingAndSortingRepository<User,Long> {

    Page<User> findAll(Pageable pageable);
}

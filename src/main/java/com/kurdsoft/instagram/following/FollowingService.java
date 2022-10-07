package com.kurdsoft.instagram.following;


import com.kurdsoft.instagram.common.exceptions.NotFound;
import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.follower.FollowerRepo;
import com.kurdsoft.instagram.user.IUserService;
import com.kurdsoft.instagram.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class FollowingService implements IFollowingService {

    private final FollowingRepo rep;
    private final IUserService service;

    @Override
    public Following save(Following following) {
        Long UserId=following.getUser().getId();
        User user=service.getById(UserId);
        following.setUser(user);
        return rep.save(following);
    }

    @Override
    public Following update(Following following) {
        Following lastItem=getById(following.getId());
        Long UserId=following.getUser().getId();
        User user=service.getById(UserId);
        lastItem.setUser(user);
        return rep.save(lastItem);
    }

    @Override
    public List<Following> getAll() {
        return (List<Following>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Following getById(Long id) {
        Optional<Following> optionalFollowing=rep.findById(id);
        if(!optionalFollowing.isPresent()){
            throw  new NotFound("Not found Id.");
        }
        return optionalFollowing.get();
    }

    @Override
    public Page<Following> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Following> getByUserId(Long id) {
        User  user=service.getById(id);
        List<Following>followings=rep.findAllByUserId(user);
        return followings;
    }
}

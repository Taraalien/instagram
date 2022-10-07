package com.kurdsoft.instagram.follower;

import com.kurdsoft.instagram.common.exceptions.NotFound;
import com.kurdsoft.instagram.like.Like;
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
public class FollowerService implements IFollowerService{

    private final FollowerRepo rep;
    private final IUserService service;
    @Override
    public Follower save(Follower follower) {
        Long UserId=follower.getUser().getId();
        User user=service.getById(UserId);
        follower.setUser(user);
        return rep.save(follower);
    }

    @Override
    public Follower update(Follower follower) {
        Follower lastItem=getById(follower.getId());
        Long UserId=follower.getUser().getId();
        User user=service.getById(UserId);
        lastItem.setUser(user);
        return rep.save(lastItem);
    }

    @Override
    public List<Follower> getAll() {
        return (List<Follower>) rep.findAll();
    }

    @Override
    public void delete(Long id) {
        rep.deleteById(id);
    }

    @Override
    public Follower getById(Long id) {
        Optional<Follower> optionalFollower=rep.findById(id);
        if(!optionalFollower.isPresent()){
            throw  new NotFound("Not found Id.");
        }
        return optionalFollower.get();
    }

    @Override
    public Page<Follower> paging(Integer page, Integer size) {
        return rep.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }

    @Override
    public List<Follower> getByUserId(Long id) {
        User  user=service.getById(id);
        List<Follower>followers=rep.findAllByUserId(user);
        return followers;
    }
}

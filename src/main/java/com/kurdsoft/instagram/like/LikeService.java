package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.common.exceptions.NotFound;
import com.kurdsoft.instagram.post.IPostService;
import com.kurdsoft.instagram.post.Post;
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
public class LikeService implements ILikeService{
    private  final IUserService userService;
    private  final IPostService service;
    private final LikeRepo repo;
    @Override
    public Like save(Like like) {
        Long userId=like.getUser().getId();
        User user=userService.getById(userId);
        Long postid=like.getPost().getId();
        Post post=service.getById(userId);
        like.setUser(user);
        like.setPost(post);
        return repo.save(like);
    }

    @Override
    public Like update(Like like) {
        Like lastItem=getById(like.getId());
        lastItem.setLikeType(like.getLikeType());
        Long userId=like.getUser().getId();
        User user=userService.getById(userId);
        Long postid=like.getPost().getId();
        Post post=service.getById(userId);
        lastItem.setUser(user);
        lastItem.setPost(post);

        return repo.save(lastItem);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Like getById(Long id) {
        Optional<Like> optionalLike=repo.findById(id);
        if(!optionalLike.isPresent()){
            throw new NotFound("Not found id.");
        }
        return optionalLike.get();
    }

    @Override
    public List<Like> getAll() {
        return (List<Like>) repo.findAll();
    }

    @Override
    public List<Like> getByPostId(Long id) {
        Post  post=service.getById(id);
        List<Like>likes=repo.findAllByPostId(post);
        return likes;
    }

    @Override
    public List<Like> getByUserId(Long id) {
        User  user=userService.getById(id);
        List<Like>likes=repo.findAllByUserId(user);
        return likes;
    }

    @Override
    public Page<Like> paging(Integer page, Integer size) {
        return repo.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}

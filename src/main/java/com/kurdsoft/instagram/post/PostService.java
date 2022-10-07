package com.kurdsoft.instagram.post;

import com.kurdsoft.instagram.common.exceptions.NotFound;
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
public class PostService implements IPostService {
    private final PostRepo repo;
    private final IUserService service;

    @Override
    public Post save(Post post) {
        Long userId=post.getUser().getId();
        User user=service.getById(userId);
        post.setUser(user);
        return repo.save(post);
    }

    @Override
    public Post update(Post post) {
        Post lastItem=getById(post.getId());
        lastItem.setCaption(post.getCaption());
        lastItem.setPhoto(post.getPhoto());
        Long userId=post.getUser().getId();
        User user=service.getById(userId);
        lastItem.setUser(user);
        return repo.save(lastItem);
    }

    @Override
    public void delete(Long id) {

        repo.deleteById(id);
    }

    @Override
    public Post getById(Long id) {
        Optional<Post> optionalPost=repo.findById(id);
        if(!optionalPost.isPresent()){
            throw new NotFound("Not found id.");
        }
        return optionalPost.get();
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) repo.findAll();
    }

    @Override
    public List<Post> getByUserId(Long id) {
        User  user=service.getById(id);
        List<Post>posts=repo.findAllByUserId(user);
        return posts;
    }

    @Override
    public Page<Post> paging(Integer page, Integer size) {
        return repo.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}

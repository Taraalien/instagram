package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.common.exceptions.NotFound;
import com.kurdsoft.instagram.like.Like;
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
public class CommentService implements ICommentService {
    private  final IUserService userService;
    private final IPostService service;
   private final CommentRepo commentRepo;

    @Override
    public Comment save(Comment comment) {
        Long userId=comment.getUser().getId();
        Long postId=comment.getPost().getId();
        User user=userService.getById(userId);
        Post post=service.getById(postId);
        comment.setPost(post);
        comment.setUser(user);
        return commentRepo.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        Comment lastItem=getById(comment.getId());
        lastItem.setComment(comment.getComment());
        Long userId=comment.getUser().getId();
        Long postId=comment.getPost().getId();
        User user=userService.getById(userId);
        Post post=service.getById(postId);
        lastItem.setPost(post);
        lastItem.setUser(user);
        return commentRepo.save(lastItem);


    }

    @Override
    public void delete(Long id) {

        commentRepo.deleteById(id);

    }

    @Override
    public Comment getById(Long id) {
        Optional<Comment> optionalComment=commentRepo.findById(id);
        if(!optionalComment.isPresent()){
            throw new NotFound("Not found id.");
        }
        return optionalComment.get();
    }

    @Override
    public List<Comment> getAll() {
        return (List<Comment>) commentRepo.findAll();
    }

    @Override
    public List<Comment> getByPostId(Long id) {
        Post  post=service.getById(id);
        List<Comment>comments=commentRepo.findAllByPostId(post);
        return comments;
    }

    @Override
    public List<Comment> getByUserId(Long id) {
        User  user=userService.getById(id);
        List<Comment>comments=commentRepo.findAllByUserId(user);
        return comments;
    }

    @Override
    public Page<Comment> paging(Integer page, Integer size) {
        return commentRepo.findAll(PageRequest.of(page,size, Sort.by("id").descending()));
    }
}

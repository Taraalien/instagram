package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.like.Like;
import com.kurdsoft.instagram.like.LikeDTO;
import com.kurdsoft.instagram.post.PostMapper;
import com.kurdsoft.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class, PostMapper.class})
public interface CommentMapper {

    Comment toComment(CommentDTO commentDTO);
    CommentDTO toCommentDto(Comment comment);

    List<Comment> toComments(List<CommentDTO> commentDTOS);
    List<CommentDTO> toCommentDtos(List<Comment> comments);
}

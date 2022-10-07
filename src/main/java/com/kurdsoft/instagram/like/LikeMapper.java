package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.post.PostDTO;
import com.kurdsoft.instagram.post.PostMapper;
import com.kurdsoft.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class, PostMapper.class})
public interface LikeMapper {

    Like toLike(LikeDTO likeDTO);
    LikeDTO toLikeDto(Like like);

    List<Like> toLikes(List<LikeDTO> likeDTOS);
    List<LikeDTO> toLikeDtos(List<Like> likes);
}

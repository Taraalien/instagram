package com.kurdsoft.instagram.post;

import com.kurdsoft.instagram.user.User;
import com.kurdsoft.instagram.user.UserDTO;
import com.kurdsoft.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface PostMapper {

    Post toPost(PostDTO  postDTO);
    PostDTO toPostDTo(Post post);

    List<Post> toPostList(List<PostDTO> postDtosList);
    List<PostDTO> toPostListDTos(List<Post> postList);
}

package com.kurdsoft.instagram.follower;

import com.kurdsoft.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface FollowerMapper {

    Follower toFollower(FollowerDTO followerDTO);
    FollowerDTO toFollowerDto(Follower follower);
    List<Follower> toFollowerDtoList(List<FollowerDTO> followerDTOS);
    List<FollowerDTO> toFollowerDtos(List<Follower> followers);
}

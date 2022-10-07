package com.kurdsoft.instagram.following;

import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.follower.FollowerDTO;
import com.kurdsoft.instagram.user.UserMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface FollowingMapper {
    Following toFollowing(FollowingDTO followingDTO);
    FollowingDTO toFollowingDto(Following following);
    List<Following> toFollowingDtoList(List<FollowingDTO> followingDTOS);
    List<FollowingDTO> toFollowingDtos(List<Following> followings);
}

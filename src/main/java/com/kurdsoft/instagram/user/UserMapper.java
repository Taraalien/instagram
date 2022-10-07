package com.kurdsoft.instagram.user;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDto);
    UserDTO toUserDto(User user);

    List<User> toUserList(List<UserDTO> userDtosList);
    List<UserDTO> toUserListDtos(List<User> userList);
}

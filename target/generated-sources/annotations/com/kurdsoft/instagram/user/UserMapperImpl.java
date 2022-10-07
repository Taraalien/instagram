package com.kurdsoft.instagram.user;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T10:33:52+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setVersion( userDto.getVersion() );
        user.setCreatedBy( userDto.getCreatedBy() );
        user.setLastModifiedDate( userDto.getLastModifiedDate() );
        user.setLastModifiedBy( userDto.getLastModifiedBy() );
        user.setUserName( userDto.getUserName() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setGmailAcount( userDto.getGmailAcount() );
        user.setPassword( userDto.getPassword() );

        return user;
    }

    @Override
    public UserDTO toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setVersion( user.getVersion() );
        userDTO.setCreatedBy( user.getCreatedBy() );
        userDTO.setLastModifiedDate( user.getLastModifiedDate() );
        userDTO.setLastModifiedBy( user.getLastModifiedBy() );
        userDTO.setUserName( user.getUserName() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        userDTO.setGmailAcount( user.getGmailAcount() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public List<User> toUserList(List<UserDTO> userDtosList) {
        if ( userDtosList == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDtosList.size() );
        for ( UserDTO userDTO : userDtosList ) {
            list.add( toUser( userDTO ) );
        }

        return list;
    }

    @Override
    public List<UserDTO> toUserListDtos(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }
}

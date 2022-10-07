package com.kurdsoft.instagram.following;

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
public class FollowingMapperImpl implements FollowingMapper {

    @Override
    public Following toFollowing(FollowingDTO followingDTO) {
        if ( followingDTO == null ) {
            return null;
        }

        Following following = new Following();

        following.setId( followingDTO.getId() );
        following.setVersion( followingDTO.getVersion() );
        following.setCreatedBy( followingDTO.getCreatedBy() );
        following.setLastModifiedDate( followingDTO.getLastModifiedDate() );
        following.setLastModifiedBy( followingDTO.getLastModifiedBy() );

        return following;
    }

    @Override
    public FollowingDTO toFollowingDto(Following following) {
        if ( following == null ) {
            return null;
        }

        FollowingDTO followingDTO = new FollowingDTO();

        followingDTO.setId( following.getId() );
        followingDTO.setVersion( following.getVersion() );
        followingDTO.setCreatedBy( following.getCreatedBy() );
        followingDTO.setLastModifiedDate( following.getLastModifiedDate() );
        followingDTO.setLastModifiedBy( following.getLastModifiedBy() );

        return followingDTO;
    }

    @Override
    public List<Following> toFollowingDtoList(List<FollowingDTO> followingDTOS) {
        if ( followingDTOS == null ) {
            return null;
        }

        List<Following> list = new ArrayList<Following>( followingDTOS.size() );
        for ( FollowingDTO followingDTO : followingDTOS ) {
            list.add( toFollowing( followingDTO ) );
        }

        return list;
    }

    @Override
    public List<FollowingDTO> toFollowingDtos(List<Following> followings) {
        if ( followings == null ) {
            return null;
        }

        List<FollowingDTO> list = new ArrayList<FollowingDTO>( followings.size() );
        for ( Following following : followings ) {
            list.add( toFollowingDto( following ) );
        }

        return list;
    }
}

package com.kurdsoft.instagram.follower;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T10:33:51+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class FollowerMapperImpl implements FollowerMapper {

    @Override
    public Follower toFollower(FollowerDTO followerDTO) {
        if ( followerDTO == null ) {
            return null;
        }

        Follower follower = new Follower();

        follower.setId( followerDTO.getId() );
        follower.setVersion( followerDTO.getVersion() );
        follower.setCreatedBy( followerDTO.getCreatedBy() );
        follower.setLastModifiedDate( followerDTO.getLastModifiedDate() );
        follower.setLastModifiedBy( followerDTO.getLastModifiedBy() );

        return follower;
    }

    @Override
    public FollowerDTO toFollowerDto(Follower follower) {
        if ( follower == null ) {
            return null;
        }

        FollowerDTO followerDTO = new FollowerDTO();

        followerDTO.setId( follower.getId() );
        followerDTO.setVersion( follower.getVersion() );
        followerDTO.setCreatedBy( follower.getCreatedBy() );
        followerDTO.setLastModifiedDate( follower.getLastModifiedDate() );
        followerDTO.setLastModifiedBy( follower.getLastModifiedBy() );

        return followerDTO;
    }

    @Override
    public List<Follower> toFollowerDtoList(List<FollowerDTO> followerDTOS) {
        if ( followerDTOS == null ) {
            return null;
        }

        List<Follower> list = new ArrayList<Follower>( followerDTOS.size() );
        for ( FollowerDTO followerDTO : followerDTOS ) {
            list.add( toFollower( followerDTO ) );
        }

        return list;
    }

    @Override
    public List<FollowerDTO> toFollowerDtos(List<Follower> followers) {
        if ( followers == null ) {
            return null;
        }

        List<FollowerDTO> list = new ArrayList<FollowerDTO>( followers.size() );
        for ( Follower follower : followers ) {
            list.add( toFollowerDto( follower ) );
        }

        return list;
    }
}

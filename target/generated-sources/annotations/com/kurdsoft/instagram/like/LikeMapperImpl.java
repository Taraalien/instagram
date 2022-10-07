package com.kurdsoft.instagram.like;

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
public class LikeMapperImpl implements LikeMapper {

    @Override
    public Like toLike(LikeDTO likeDTO) {
        if ( likeDTO == null ) {
            return null;
        }

        Like like = new Like();

        like.setId( likeDTO.getId() );
        like.setVersion( likeDTO.getVersion() );
        like.setCreatedBy( likeDTO.getCreatedBy() );
        like.setLastModifiedDate( likeDTO.getLastModifiedDate() );
        like.setLastModifiedBy( likeDTO.getLastModifiedBy() );

        return like;
    }

    @Override
    public LikeDTO toLikeDto(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeDTO likeDTO = new LikeDTO();

        likeDTO.setId( like.getId() );
        likeDTO.setVersion( like.getVersion() );
        likeDTO.setCreatedBy( like.getCreatedBy() );
        likeDTO.setLastModifiedDate( like.getLastModifiedDate() );
        likeDTO.setLastModifiedBy( like.getLastModifiedBy() );

        return likeDTO;
    }

    @Override
    public List<Like> toLikes(List<LikeDTO> likeDTOS) {
        if ( likeDTOS == null ) {
            return null;
        }

        List<Like> list = new ArrayList<Like>( likeDTOS.size() );
        for ( LikeDTO likeDTO : likeDTOS ) {
            list.add( toLike( likeDTO ) );
        }

        return list;
    }

    @Override
    public List<LikeDTO> toLikeDtos(List<Like> likes) {
        if ( likes == null ) {
            return null;
        }

        List<LikeDTO> list = new ArrayList<LikeDTO>( likes.size() );
        for ( Like like : likes ) {
            list.add( toLikeDto( like ) );
        }

        return list;
    }
}

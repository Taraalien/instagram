package com.kurdsoft.instagram.post;

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
public class PostMapperImpl implements PostMapper {

    @Override
    public Post toPost(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setVersion( postDTO.getVersion() );
        post.setCreatedBy( postDTO.getCreatedBy() );
        post.setLastModifiedDate( postDTO.getLastModifiedDate() );
        post.setLastModifiedBy( postDTO.getLastModifiedBy() );
        post.setPhoto( postDTO.getPhoto() );
        post.setCaption( postDTO.getCaption() );

        return post;
    }

    @Override
    public PostDTO toPostDTo(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setVersion( post.getVersion() );
        postDTO.setCreatedBy( post.getCreatedBy() );
        postDTO.setLastModifiedDate( post.getLastModifiedDate() );
        postDTO.setLastModifiedBy( post.getLastModifiedBy() );
        postDTO.setPhoto( post.getPhoto() );
        postDTO.setCaption( post.getCaption() );

        return postDTO;
    }

    @Override
    public List<Post> toPostList(List<PostDTO> postDtosList) {
        if ( postDtosList == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( postDtosList.size() );
        for ( PostDTO postDTO : postDtosList ) {
            list.add( toPost( postDTO ) );
        }

        return list;
    }

    @Override
    public List<PostDTO> toPostListDTos(List<Post> postList) {
        if ( postList == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( postList.size() );
        for ( Post post : postList ) {
            list.add( toPostDTo( post ) );
        }

        return list;
    }
}

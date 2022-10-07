package com.kurdsoft.instagram.comment;

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
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment toComment(CommentDTO commentDTO) {
        if ( commentDTO == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setId( commentDTO.getId() );
        comment.setVersion( commentDTO.getVersion() );
        comment.setCreatedBy( commentDTO.getCreatedBy() );
        comment.setLastModifiedDate( commentDTO.getLastModifiedDate() );
        comment.setLastModifiedBy( commentDTO.getLastModifiedBy() );

        return comment;
    }

    @Override
    public CommentDTO toCommentDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId( comment.getId() );
        commentDTO.setVersion( comment.getVersion() );
        commentDTO.setCreatedBy( comment.getCreatedBy() );
        commentDTO.setLastModifiedDate( comment.getLastModifiedDate() );
        commentDTO.setLastModifiedBy( comment.getLastModifiedBy() );

        return commentDTO;
    }

    @Override
    public List<Comment> toComments(List<CommentDTO> commentDTOS) {
        if ( commentDTOS == null ) {
            return null;
        }

        List<Comment> list = new ArrayList<Comment>( commentDTOS.size() );
        for ( CommentDTO commentDTO : commentDTOS ) {
            list.add( toComment( commentDTO ) );
        }

        return list;
    }

    @Override
    public List<CommentDTO> toCommentDtos(List<Comment> comments) {
        if ( comments == null ) {
            return null;
        }

        List<CommentDTO> list = new ArrayList<CommentDTO>( comments.size() );
        for ( Comment comment : comments ) {
            list.add( toCommentDto( comment ) );
        }

        return list;
    }
}

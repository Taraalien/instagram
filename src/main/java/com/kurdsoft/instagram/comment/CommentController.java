package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.common.PagingData;
import com.kurdsoft.instagram.like.ILikeService;
import com.kurdsoft.instagram.like.Like;
import com.kurdsoft.instagram.like.LikeDTO;
import com.kurdsoft.instagram.like.LikeMapper;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment/")
@AllArgsConstructor
@Data
public class CommentController {

    private final ICommentService service;
    private CommentMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.save(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody CommentDTO commentDTO){
        Comment comment=mapper.toComment(commentDTO);
        service.update(comment);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



    @GetMapping("/v1/{id}")
    public ResponseEntity<CommentDTO> getById(@PathVariable Long id) {
        Comment  comment= service.getById(id);
        CommentDTO dto = mapper.toCommentDto(comment);
        return ResponseEntity.ok(dto);
    }



    @GetMapping("/v1")
    public ResponseEntity<List<CommentDTO>> getAll(){
        List<Comment>comments=service.getAll();
        List<CommentDTO> commentDTOS=mapper.toCommentDtos(comments);
        return ResponseEntity.ok(commentDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<CommentDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Comment> comments=service.paging(page,size);
        int totalPage=comments.getTotalPages();
        List<Comment> data=comments.getContent();
        List<CommentDTO> postDTOS=mapper.toCommentDtos(data);
        PagingData<CommentDTO> pagingData=new PagingData<>(totalPage,page,postDTOS);
        return ResponseEntity.ok(pagingData);
    }

    @Timed("comment.getAll")
    @GetMapping("/v1/get-all-by-post-id/{post_id}")
    public ResponseEntity<List<CommentDTO>> getAllByPostId(@PathVariable Long id){
        List<Comment>comments=service.getByPostId(id);
        List<CommentDTO> commentDTOS=mapper.toCommentDtos(comments);
        return ResponseEntity.ok(commentDTOS);
    }


    @Timed("comment.getAll")
    @GetMapping("/v1/get-all-by-user-id/{user_id}")
    public ResponseEntity<List<CommentDTO>> getAllbyUserId(@PathVariable Long id){
        List<Comment>comments=service.getByUserId(id);
        List<CommentDTO> commentDTOS=mapper.toCommentDtos(comments);
        return ResponseEntity.ok(commentDTOS);
    }
}

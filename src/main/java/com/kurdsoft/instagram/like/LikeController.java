package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.common.PagingData;
import com.kurdsoft.instagram.post.Post;
import com.kurdsoft.instagram.post.PostDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like/")
@AllArgsConstructor
@Data
public class LikeController {

    private final ILikeService service;
    private LikeMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.save(like);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody LikeDTO likeDTO){
        Like like=mapper.toLike(likeDTO);
        service.update(like);
        return ResponseEntity.ok().build();

    }



    @GetMapping("/v1/{id}")
    public ResponseEntity<LikeDTO> getById(@PathVariable Long id) {
        Like  like= service.getById(id);
        LikeDTO dto = mapper.toLikeDto(like);
        return ResponseEntity.ok(dto);
    }



    @GetMapping("/v1")
    public ResponseEntity<List<LikeDTO>> getAll(){
        List<Like>likes=service.getAll();
        List<LikeDTO> likeDTOS=mapper.toLikeDtos(likes);
        return ResponseEntity.ok(likeDTOS);

    }


    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<LikeDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Like> likes=service.paging(page,size);
        int totalPage=likes.getTotalPages();
        List<Like> data=likes.getContent();
        List<LikeDTO> postDTOS=mapper.toLikeDtos(data);
        PagingData<LikeDTO> pagingData=new PagingData<>(totalPage,page,postDTOS);
        return ResponseEntity.ok(pagingData);
    }

    @Timed("like.getAll")
    @GetMapping("/v1/get-all-by-post-id/{post_id}")
    public ResponseEntity<List<LikeDTO>> getAllByPostId(@PathVariable Long id){
        List<Like>likes=service.getByPostId(id);
        List<LikeDTO> likeDTOS=mapper.toLikeDtos(likes);
        return ResponseEntity.ok(likeDTOS);
    }

    @Timed("like.getAll")
    @GetMapping("/v1/get-all-by-user-id/{user_id}")
    public ResponseEntity<List<LikeDTO>> getAllbyUserId(@PathVariable Long id){
        List<Like>likes=service.getByUserId(id);
        List<LikeDTO> likeDTOS=mapper.toLikeDtos(likes);
        return ResponseEntity.ok(likeDTOS);
    }
}

package com.kurdsoft.instagram.post;


import com.kurdsoft.instagram.common.PagingData;
import com.kurdsoft.instagram.user.User;
import com.kurdsoft.instagram.user.UserDTO;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post/")
@AllArgsConstructor
@Data
public class PostController {
    private final IPostService service;
    private PostMapper mapper;

    @Timed("post.getAll")
    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody PostDTO postDTO){
        Post post=mapper.toPost(postDTO);
        service.save(post);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Timed("post.getAll")
    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody PostDTO postDTO){
        Post post=mapper.toPost(postDTO);
        service.update(post);
        return ResponseEntity.ok().build();

    }


    @Timed("post.getAll")
    @GetMapping("/v1/{id}")
    public ResponseEntity<PostDTO> getById(@PathVariable Long id) {
        Post  post= service.getById(id);
        PostDTO dto = mapper.toPostDTo(post);
        return ResponseEntity.ok(dto);
    }


    @Timed("post.getAll")
    @GetMapping("/v1")
    public ResponseEntity<List<PostDTO>> getAll(){
        List<Post>posts=service.getAll();
        List<PostDTO> postDTOS=mapper.toPostListDTos(posts);
        return ResponseEntity.ok(postDTOS);

    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Timed("post.getAll")
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<PostDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Post> posts=service.paging(page,size);
        int totalPage=posts.getTotalPages();
        List<Post> data=posts.getContent();
        List<PostDTO> postDTOS=mapper.toPostListDTos(data);
        PagingData<PostDTO> pagingData=new PagingData<>(totalPage,page,postDTOS);
        return ResponseEntity.ok(pagingData);
    }

    @Timed("post.getAll")
    @GetMapping("/v1/get-all-by-user-id/{user_id}")
    public ResponseEntity<List<PostDTO>> getAllByUsertId(@PathVariable Long id){
        List<Post>posts=service.getByUserId(id);
        List<PostDTO> postDTOS=mapper.toPostListDTos(posts);
        return ResponseEntity.ok(postDTOS);
    }
}

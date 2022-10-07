package com.kurdsoft.instagram.follower;


import com.kurdsoft.instagram.common.PagingData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/follower/")
@Data
public class FollowerController {

    private final IFollowerService service;
    private FollowerMapper  mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FollowerDTO dto){
        Follower follower=mapper.toFollower(dto);
        service.save(follower);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody FollowerDTO dto){
        Follower follower=mapper.toFollower(dto);
        service.update(follower);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowerDTO> getById(@PathVariable Long id) {
        Follower follower= service.getById(id);
        FollowerDTO dto = mapper.toFollowerDto(follower);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<FollowerDTO>> getAll(){
        List<Follower>followers=service.getAll();
        List<FollowerDTO> followerDTOS=mapper.toFollowerDtos(followers);
        return ResponseEntity.ok(followerDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<FollowerDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Follower> followers=service.paging(page,size);
        int totalPage=followers.getTotalPages();
        List<Follower> data=followers.getContent();
        List<FollowerDTO> itemsDTOS=mapper.toFollowerDtos(data);
        PagingData<FollowerDTO> pagingData=new PagingData<>(totalPage,page,itemsDTOS);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-suserid/{user_id}")
    public ResponseEntity<List<FollowerDTO>> getAllByUserId(@PathVariable Long id){
        List<Follower>followers=service.getByUserId(id);
        List<FollowerDTO> followerDTOS=mapper.toFollowerDtos(followers);
        return ResponseEntity.ok(followerDTOS);
    }
}

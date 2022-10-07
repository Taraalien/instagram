package com.kurdsoft.instagram.following;


import com.kurdsoft.instagram.common.PagingData;
import com.kurdsoft.instagram.follower.Follower;
import com.kurdsoft.instagram.follower.FollowerDTO;
import com.kurdsoft.instagram.follower.FollowerMapper;
import com.kurdsoft.instagram.follower.IFollowerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/following/")
@Data
public class FollowingController {

    private final IFollowingService service;
    private FollowingMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody FollowingDTO dto){
        Following following=mapper.toFollowing(dto);
        service.save(following);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody FollowingDTO dto){
        Following following=mapper.toFollowing(dto);
        service.update(following);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<FollowingDTO> getById(@PathVariable Long id) {
        Following following= service.getById(id);
        FollowingDTO dto = mapper.toFollowingDto(following);
        return ResponseEntity.ok(dto);
    }


    @GetMapping("/v1")
    public ResponseEntity<List<FollowingDTO>> getAll(){
        List<Following>followings =service.getAll();
        List<FollowingDTO> followingDTOS=mapper.toFollowingDtos(followings);
        return ResponseEntity.ok(followingDTOS);

    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<FollowingDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<Following> followings=service.paging(page,size);
        int totalPage=followings.getTotalPages();
        List<Following> data=followings.getContent();
        List<FollowingDTO> followingDTOS=mapper.toFollowingDtos(data);
        PagingData<FollowingDTO> pagingData=new PagingData<>(totalPage,page,followingDTOS);
        return ResponseEntity.ok(pagingData);
    }


    @GetMapping("/v1/get-all-by-suserid/{user_id}")
    public ResponseEntity<List<FollowingDTO>> getAllByUserId(@PathVariable Long id){
        List<Following>followings=service.getByUserId(id);
        List<FollowingDTO> followingrDTOS=mapper.toFollowingDtos(followings);
        return ResponseEntity.ok(followingrDTOS);
    }
}

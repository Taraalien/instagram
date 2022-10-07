package com.kurdsoft.instagram.user;


import com.kurdsoft.instagram.common.PagingData;
import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@AllArgsConstructor
@Data
public class UserController {

    private final IUserService userService;
    private UserMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user=mapper.toUser(userDTO);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody UserDTO userDTO){
        User user=mapper.toUser(userDTO);
        userService.update(user);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        UserDTO dto = mapper.toUserDto(user);
        return ResponseEntity.ok(dto);
    }



    @GetMapping("/v1")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<User>users=userService.getAll();
        List<UserDTO>userDTOS=mapper.toUserListDtos(users);
        return ResponseEntity.ok(userDTOS);

    }


    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Timed("user.getAll")
    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<UserDTO>> findAll(@PathVariable Integer page, Integer size){
        Page<User> users=userService.paging(page,size);
        int totalPage=users.getTotalPages();
        List<User> data=users.getContent();
        List<UserDTO> userDTOS=mapper.toUserListDtos(data);
        PagingData<UserDTO> pagingData=new PagingData<>(totalPage,page,userDTOS);
        return ResponseEntity.ok(pagingData);
    }

}

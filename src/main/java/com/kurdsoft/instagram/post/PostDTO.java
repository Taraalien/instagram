package com.kurdsoft.instagram.post;

import com.kurdsoft.instagram.common.base.BaseDTO;
import com.kurdsoft.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PostDTO extends BaseDTO {


    @ApiModelProperty(required = true,hidden = false)
    private String photo;

    @ApiModelProperty(required = true,hidden = false)
    private String caption;


   @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> userDTO;
}

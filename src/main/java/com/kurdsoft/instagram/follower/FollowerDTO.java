package com.kurdsoft.instagram.follower;

import com.kurdsoft.instagram.common.base.BaseDTO;
import com.kurdsoft.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FollowerDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> userDTO;
}

package com.kurdsoft.instagram.following;

import com.kurdsoft.instagram.common.base.BaseDTO;
import com.kurdsoft.instagram.user.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class FollowingDTO extends BaseDTO {
    @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> userDTOList;
}

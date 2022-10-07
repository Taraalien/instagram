package com.kurdsoft.instagram.like;

import com.kurdsoft.instagram.common.base.BaseDTO;
import com.kurdsoft.instagram.post.PostDTO;
import com.kurdsoft.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class LikeDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private LikeType likeType;

    @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> userDTO;

    @ApiModelProperty(required = true,hidden = false)
    private List<PostDTO> postDTO;
}

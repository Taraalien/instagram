package com.kurdsoft.instagram.comment;

import com.kurdsoft.instagram.common.base.BaseDTO;
import com.kurdsoft.instagram.like.LikeType;
import com.kurdsoft.instagram.post.PostDTO;
import com.kurdsoft.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class CommentDTO extends BaseDTO {

    @ApiModelProperty(required = false,hidden = false)
    private String comment;

    @ApiModelProperty(required = true,hidden = false)
    private List<UserDTO> userDTO;

    @ApiModelProperty(required = true,hidden = false)
    private List<PostDTO> postDTO;
}

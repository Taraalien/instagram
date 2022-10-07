package com.kurdsoft.instagram.user;

import com.kurdsoft.instagram.common.base.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String userName;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;


    @ApiModelProperty(required = true,hidden = false)
    private String gmailAcount;

    @ApiModelProperty(required = true,hidden = false)
    private String password;


}

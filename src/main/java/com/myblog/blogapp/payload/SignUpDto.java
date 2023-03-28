package com.myblog.blogapp.payload;

import lombok.Data;

@Data
public class SignUpDto {//create same as user class
    private String name;
    private String username;
    private String email;
    private String password;

}

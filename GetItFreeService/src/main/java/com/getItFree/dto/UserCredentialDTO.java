package com.getItFree.dto;

import com.getItFree.model.Authority;
import lombok.Data;

import java.util.List;

@Data
public class UserCredentialDTO {
    private Long id;
    private String username;
    private String password;
    private List<Authority> authority;
}

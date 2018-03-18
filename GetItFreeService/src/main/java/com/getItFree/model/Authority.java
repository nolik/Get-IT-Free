package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@Document
public class Authority implements GrantedAuthority {

    public enum AuthorityRole {
        ROLE_USER, ROLE_ADMIN
    }
    
    private AuthorityRole authorityRole;

    @Override
    public String getAuthority() {
        return authorityRole.name();
    }
}

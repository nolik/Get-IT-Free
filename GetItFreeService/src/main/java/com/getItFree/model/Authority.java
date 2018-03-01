package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Authority implements GrantedAuthority {

    public enum AuthorityRole {
        USER, ADMIN
    }
    
    private AuthorityRole authorityRole;

    @Override
    public String getAuthority() {
        return authorityRole.name();
    }
}

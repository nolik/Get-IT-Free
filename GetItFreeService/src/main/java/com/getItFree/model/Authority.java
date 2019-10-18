package com.getItFree.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    public enum AuthorityRole {
        ROLE_USER, ROLE_ADMIN
    }

    public Authority(AuthorityRole authorityRole) {
        this.authorityRole = authorityRole;
    }

    private AuthorityRole authorityRole;

    @Override
    public String getAuthority() {
        return authorityRole.name();
    }
}

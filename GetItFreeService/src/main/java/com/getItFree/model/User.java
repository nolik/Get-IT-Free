package com.getItFree.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements UserDetails, Serializable {
    private static final String ROLE_PREFIX = "ROLE_";

    enum Authority {
        USER, ADMIN
    }

    @Id
    @Generated
    private BigInteger _id;
    private String username;
    private String password;
    private Email email;
    private Date creationDate;
    private Authority authority;

    //way to avoid of creation separate Authority instance in db
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> list = new ArrayList<>();

            list.add(new SimpleGrantedAuthority(ROLE_PREFIX + authority));

            return list;
    }

    // Able to add the below fields in the users table.
    // For now => hardcoded.
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}

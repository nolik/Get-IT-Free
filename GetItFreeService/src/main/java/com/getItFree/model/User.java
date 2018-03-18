package com.getItFree.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements UserDetails, Serializable {

    @Id
    @Generated
    private BigInteger _id;
    private String username;
    private String password;
    @Email
    private String email;
    @CreatedDate
    private DateTime creationDate;
    private List<Authority> authority;

    //way to avoid of creation separate Authority instance in db
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            return authority;
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

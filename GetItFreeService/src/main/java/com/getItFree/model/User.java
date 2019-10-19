package com.getItFree.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String phone;

    @Email
    private String email;

    @CreatedDate
    private DateTime creationDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Authority> authority;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "giver",
            orphanRemoval = true
    )
    private List<Advert> adverts = new ArrayList<>();

    public Advert addAdvert(Advert advert) {
        adverts.add(advert);

        return advert;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "taker",
            orphanRemoval = true
    )
    private List<Advert> tookAdverts;

    public Advert addTookAdvert(Advert advert) {
        tookAdverts.add(advert);

        return advert;
    }

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

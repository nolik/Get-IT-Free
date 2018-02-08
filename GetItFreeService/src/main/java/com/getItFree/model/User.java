package com.getItFree.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
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
}

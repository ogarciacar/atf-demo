package com.gig.atfdemo.user.domain;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class User {
     int id;
     String email;
     String firstName;
     String lastName;
     String avatar;

    public User(int id, String email, String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }
}

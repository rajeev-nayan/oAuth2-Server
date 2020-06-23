package com.soprabanking.dxp.authserver.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserInfo {

    @Id
    String id;

    String username;

    String password;

    public UserInfo(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public UserInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getId() {
        return id;
    }

    public UserInfo setId(String id) {
        this.id = id;
        return this;
    }
}

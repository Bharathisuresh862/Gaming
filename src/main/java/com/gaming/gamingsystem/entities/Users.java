package com.gaming.gamingsystem.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin_users")
public class Users {
    @Id private String id;
    private String username;
    private String password;
    private String status;

    public Users() {}
    public Users(String id, String username, String password, String status){ this.id=id; this.username=username; this.password=password; this.status=status;}
    // getters/setters
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getUsername(){return username;} public void setUsername(String username){this.username=username;}
    public String getPassword(){return password;} public void setPassword(String password){this.password=password;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
}

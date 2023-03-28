package com.myblog.blogapp.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="users",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),
                                         @UniqueConstraint(columnNames = "email")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String name;
    private String username;
    private String password;
    //maping with user and role table with user role table
    // user_roles -> mediator table
    // @JoinColumn(name="user_id",referencedColumnName = "id"-> user primary key become foreingn key of user _roles table
    // inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))->roles pk become user_roles fk
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private Set<Role> roles;
}

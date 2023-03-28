package com.myblog.blogapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data   // giving getter and setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts" ,uniqueConstraints={@UniqueConstraint(columnNames = {"title"})})
public class Post {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    private long id;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="description",nullable = false)
    private String description;
    @Lob
    @Column(name="content",nullable = false)
    private String content;//string hold max 255 charecter so for that use @Lob
@OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
Set<Comment> comments=new HashSet<>();

}

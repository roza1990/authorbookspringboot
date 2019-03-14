package com.example.authorbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "pic_url")
    private String picUrl;
    @ManyToOne
    private Author author;
    @ManyToMany(mappedBy = "bookList")
    Set<User> userList;



}

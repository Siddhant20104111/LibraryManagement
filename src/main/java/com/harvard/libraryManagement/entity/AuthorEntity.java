package com.harvard.libraryManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorEntity extends TimeStamps {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Column(length=50)
     private String name;

     @Column(nullable = false, unique = true,length = 50)
     private String email;

     @OneToMany(mappedBy = "author")
     private List<BookEntity> bookList;    //this is bidirectional relationship
}

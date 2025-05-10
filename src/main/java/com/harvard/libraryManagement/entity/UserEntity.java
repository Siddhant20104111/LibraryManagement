package com.harvard.libraryManagement.entity;

import com.harvard.libraryManagement.entity.enums.BookType;
import com.harvard.libraryManagement.entity.enums.UserStatus;
import com.harvard.libraryManagement.entity.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserEntity extends TimeStamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(length = 50)
    private String name;

    @Column(unique = true, length = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true, length = 50)
    private String email;

    private String address;

    @Enumerated
    private UserStatus userStatus;

    @Enumerated(value = EnumType.STRING)
    private UserType userType;

    @Transient
    private String temp;

    @OneToMany (mappedBy = "user")
    private List<BookEntity> books;   //this is bidirectional relationship

    @OneToMany(mappedBy = "user")
    private List<TransactionEntity> transactions;
}


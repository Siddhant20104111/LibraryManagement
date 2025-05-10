package com.harvard.libraryManagement.entity;

import com.harvard.libraryManagement.entity.enums.BookType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookEntity extends TimeStamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(length=50)
    private String title;

    @Column(length=20, unique= true)
    private String bookNo;

    @Enumerated
    private BookType bookType;

    @Column(nullable= false)
    private Double securityAmount;

    @ManyToOne
    @JoinColumn
    private UserEntity user; //this is bidirectional relationship


    @ManyToOne
    @JoinColumn
    private AuthorEntity author; //this is bidirectional relationship

    @OneToMany (mappedBy = "book")
    private List<TransactionEntity> transactions;
}

package com.harvard.libraryManagement.entity;


import com.harvard.libraryManagement.entity.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String transactionId;

    @Column
    private TransactionStatus transactionStatus;

    private Double settlementAmount; //It can be both positive and negative
                                     //depending upon when u are returning the book

    private Date issuedDate;

    private Date submittedDate;

    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private BookEntity book;
}

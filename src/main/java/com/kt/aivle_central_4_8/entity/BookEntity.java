package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookEntity {
    @Id
    private String bookId;
}

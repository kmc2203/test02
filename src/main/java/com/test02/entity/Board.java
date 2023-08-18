package com.test02.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Board {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq2")
   @SequenceGenerator(name = "board_seq2", sequenceName = "board_seq2", allocationSize = 1)
    private Integer id;

    private String title;


    private String content;

    @CreationTimestamp
    @Column(name = "regDt", updatable = false)
    private LocalDateTime regDt;

    @UpdateTimestamp
    @Column(name = "modDt")
    private LocalDateTime modDt;
}

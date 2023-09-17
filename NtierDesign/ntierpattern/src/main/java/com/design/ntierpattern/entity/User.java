package com.design.ntierpattern.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "KULLANICILAR")
@Data
public class User extends BaseEntity{
    @Id
    //@SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen",initialValue = 1,allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ISIM",length = 100)
    private String name;
    @Column(name = "SOYISIM",length = 100)
    private String surname;
}

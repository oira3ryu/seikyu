package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="office")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Office {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="number")
    private String number;

    @Column(name="name")
    private String name;

    @Column(name="pcode")
    private String pcode;

    @Column(name="address")
    private String address;

    @Column(name="phonenumber")
    private String phonenumber;

    @Column(name="manager")
    private String manager;

    @Column(name="stuff")
    private String stuff;

    @Column(name="flg")
    private boolean flg;
}
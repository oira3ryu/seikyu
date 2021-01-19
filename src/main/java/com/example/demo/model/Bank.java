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
@Table(name="bank")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Bank {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="bid")
    private String bid;

    @Column(name="bcode")
    private String bcode;

    @Column(name="bname")
    private String bname;

    @Column(name="sbname")
    private String sbname;

    @Column(name="brcode")
    private String brcode;

    @Column(name="brname")
    private String brname;

    @Column(name="sd")
    private String sd;

    @Column(name="sm")
    private String sm;

    @Column(name="sy")
    private String sy;
}
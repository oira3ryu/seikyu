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
@Table(name="syubetsu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Syubetsu {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="shisetsumei")
    private String shisetsumei;

    @Column(name="ofid")
    private String ofid;

    @Column(name="sid")
    private String sid;

    @Column(name="hyoujimei")
    private String hyoujimei;
}

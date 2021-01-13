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
@Table(name="t_syubetsu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Syubetsu {
    @Id
    @Column(name="ps_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ps_id;

    @Column(name="syubetsu")
    private String syubetsu;

    @Column(name="shisetsumei")
    private String shisetsumei;

    @Column(name="o_id")
    private String o_id;

    @Column(name="s_id")
    private String s_id;

    @Column(name="hyoujimei")
    private String hyoujimei;
}

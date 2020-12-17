package com.example.demo.model;

import java.sql.Timestamp;

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
@Table(name="t_csv")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Csv {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="c1")
    private String c1;

    @Column(name="c2")
    private String c2;

    @Column(name="c3")
    private String c3;

    @Column(name="c4")
    private String c4;

    @Column(name="c5")
    private String c5;

    @Column(name="c6")
    private String c6;

    @Column(name="c7")
    private String c7;

    @Column(name="c8")
    private String c8;

    @Column(name="c9")
    private String c9;

    @Column(name="c10")
    private String c10;

    @Column(name="c11")
    private String c11;

    @Column(name="c12")
    private String c12;

    @Column(name="c13")
    private String c13;

    @Column(name="c14")
    private String c14;

    @Column(name="c15")
    private String c15;

    @Column(name="c16")
    private String c16;

    @Column(name="c17")
    private String c17;

    @Column(name="c18")
    private String c18;

    @Column(name="c19")
    private String c19;

    @Column(name="c20")
    private String c20;

    @Column(name="c21")
    private String c21;

    @Column(name="c22")
    private String c22;

    @Column(name="c23")
    private String c23;

    @Column(name="c24")
    private String c24;

    @Column(name="c25")
    private String c25;

    @Column(name="c26")
    private String c26;

    @Column(name="c27")
    private String c27;

    @Column(name="c28")
    private String c28;

    @Column(name="c29")
    private String c29;

    @Column(name="c30")
    private String c30;

    @Column(name="c31")
    private String c31;

    @Column(name="c32")
    private String c32;

    @Column(name="c33")
    private String c33;

    @Column(name="c34")
    private String c34;

    @Column(name="c35")
    private String c35;

    @Column(name="c36")
    private String c36;

    @Column(name="c37")
    private String c37;

    @Column(name="c38")
    private String c38;

    @Column(name="c39")
    private String c39;

    @Column(name="c40")
    private String c40;

    @Column(name="c41")
    private String c41;

    @Column(name="c42")
    private String c42;

    @Column(name="c43")
    private String c43;

    @Column(name="c44")
    private String c44;

    @Column(name="c45")
    private String c45;

    @Column(name="c46")
    private String c46;

    @Column(name="c47")
    private String c47;

    @Column(name="c48")
    private String c48;

    @Column(name="c49")
    private String c49;

    @Column(name="c50")
    private String c50;

    @Column(name="c51")
    private String c51;

    @Column(name="c52")
    private String c52;

    @Column(name="c53")
    private String c53;

    @Column(name="c54")
    private String c54;

    @Column(name="c55")
    private String c55;

    @Column(name="c56")
    private String c56;

    @Column(name="c57")
    private String c57;

    @Column(name="c58")
    private String c58;

    @Column(name="time_stamp")
    private Timestamp time_stamp;

    @Column(name="s_id")
    private String s_id;

    @Column(name="p_id")
    private String p_id;

    @Column(name="req_id")
    private String req_id;

    @Column(name="nen")
    private String nen;

    @Column(name="tsuki")
    private String tsuki;

    @Column(name="g_id")
    private String g_id;

    @Column(name="o_id")
    private Integer o_id;

}
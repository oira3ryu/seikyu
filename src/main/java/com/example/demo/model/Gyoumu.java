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
@Table(name="t_gyoumu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Gyoumu {
    @Id
    @Column(name="g_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer g_id;

    @Column(name="gyoumu")
    private String gyoumu;
}

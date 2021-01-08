package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class test {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="price")
    @NotNull
    @PositiveOrZero
    private Integer price;

    @Column(name="time_stamp")
    private Timestamp time_stamp;

    @PrePersist
    public void onPrePersist() {
    	setTime_stamp(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    public void onPreUpdate() {
    	setTime_stamp(new Timestamp(System.currentTimeMillis()));
    }
}

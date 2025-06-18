package com.mvp.store.storeApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "items")

public class Store {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column(unique = true, nullable = false)
    String item_name;

    @Column(nullable = false)
    Float price;

    @Column(nullable = false)
    Integer quantity;



}

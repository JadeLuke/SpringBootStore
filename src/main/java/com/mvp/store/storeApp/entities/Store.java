package com.mvp.store.storeApp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Store {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String item_name;

    @Column
    Float price;

    @Column
    Integer quantity;

  @ManyToOne
  @JoinColumn(name = "supplier_id", nullable = false)
  Supplier supplier;

}

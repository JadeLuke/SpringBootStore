package com.mvp.store.storeApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Supplier {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    String contact;



    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Store> items; // A list that holds all the items supplied by the supplier

    // This defines a one-to-many relationship: one Supplier can supply many items.
    // - 'mappedBy = "supplier"' means the 'supplier' field in the Store class owns the relationship.
    // - 'cascade = CascadeType.ALL' means any changes to Supplier (like save/delete) will apply to its Stores.
    // - 'orphanRemoval = true' means if a Store is removed from the list, it will be deleted
}


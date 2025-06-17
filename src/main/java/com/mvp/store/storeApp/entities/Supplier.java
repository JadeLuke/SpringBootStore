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
@Table(name = "suppliers")

public class Supplier {
    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column(unique = true)
    String name;

    @Column
    String contact;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_item_id", referencedColumnName = "id")
    List<Store> store;
}


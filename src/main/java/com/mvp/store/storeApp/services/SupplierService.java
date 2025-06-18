package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<Supplier> getSupplier();
    Optional<Supplier> getSupplierById(Long id);
    Supplier insert(Supplier supplier);
    void updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
}


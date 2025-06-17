package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Supplier;

import java.util.List;

    public interface SupplierService {
    List<Supplier> getSupplier();
    Supplier getSupplierById(Long id);
    Supplier insert(Supplier supplier);
    void updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
}


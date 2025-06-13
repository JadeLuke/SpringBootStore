package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Store;
import com.mvp.store.storeApp.entities.Supplier;

import java.util.List;

    public interface SupplierService {
    List<Supplier> getSuppliers();
    Supplier getSupplierById(Long id);
    Supplier insert(Supplier supplier);
    void updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);
}


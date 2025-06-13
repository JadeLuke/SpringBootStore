package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Store;

import java.util.List;

public  interface StoreService {
    List<Store> getItems();
    Store getStoreById(Long id);
    Store insert(Store store);
    void updateStore(Long id, Store store);
    void deleteStore(Long storeId);
}

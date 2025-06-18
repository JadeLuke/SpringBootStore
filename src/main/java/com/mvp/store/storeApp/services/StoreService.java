package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Store;

import java.util.List;
import java.util.Optional;

public  interface StoreService {
    List<Store> getItems();
   Optional <Store> getItemById(Long id);
    Store insert(Store store);
    void updateItem(Long id, Store store);
    void deleteById(Long itemId);
}

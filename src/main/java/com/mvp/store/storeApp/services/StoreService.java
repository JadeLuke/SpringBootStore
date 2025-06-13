package com.mvp.store.storeApp.services;

import com.mvp.store.storeApp.entities.Store;

import java.util.List;

public  interface StoreService {
    List<Store> getItems();
    Store getItemById(Long id);
    Store insert(Store store);
    void updateItem(Long id, Store store);
    void deleteItem(Long itemId);
}

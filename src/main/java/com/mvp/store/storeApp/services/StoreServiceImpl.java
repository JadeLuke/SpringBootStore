package com.mvp.store.storeApp.services;


import com.mvp.store.storeApp.entities.Store;

import com.mvp.store.storeApp.repositories.StoreRepository;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getItems() {
        List<Store> Items = new ArrayList<>();
        storeRepository.findAll().forEach(Items::add);
        return Items;
    }

    @Override
    public Optional<Store> getItemById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public Store insert(Store store) {
        return storeRepository.save(store);
    }

    @Override
//    public void updateItem
//            (Long id, Store store) {
//        Store itemsFromDb = storeRepository.findById(id).get();
//        System.out.println(itemsFromDb.toString());
//        itemsFromDb.setItem_name(store.getItem_name());
//        itemsFromDb.setQuantity(store.getQuantity());
//        itemsFromDb.setPrice(store.getPrice());
//
//
//        storeRepository.save(itemsFromDb);
//    }
    public void updateItem(Long id, Store store) {
        Optional<Store> optionalItem = storeRepository.findById(id);

        if (optionalItem.isEmpty()) {
            throw new RuntimeException("Item with ID " + id + " not found.");
        }

        Store itemsFromDb = optionalItem.get();

        itemsFromDb.setItem_name(store.getItem_name());
        itemsFromDb.setQuantity(store.getQuantity());
        itemsFromDb.setPrice(store.getPrice());

        storeRepository.save(itemsFromDb);
    }


    @Override
    public void deleteById(Long itemId) {

        storeRepository.deleteById(itemId);
    }


}



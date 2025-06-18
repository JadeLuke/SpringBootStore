package com.mvp.store.storeApp.controllers;


import com.mvp.store.storeApp.entities.Store;
import com.mvp.store.storeApp.services.StoreService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/store")
public class StoreController {

    StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Store>> getAllItems(){
        List<Store> items = storeService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping({"/{itemId}"})
    public ResponseEntity<Store> getItem(@PathVariable Long itemId){
        Store store = storeService.getItemById(itemId);
            return new ResponseEntity<>(storeService.getItemById(itemId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Store> saveItem(@RequestBody Store store){
        Store store1 = storeService.insert(store);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("store", "/api/v1/store" + store1.getId().toString());
        return new ResponseEntity<>(store1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{itemId}"})
    public ResponseEntity<Store> updateItem(@PathVariable("itemId") Long itemId, @RequestBody Store store){
        storeService.updateItem(itemId, store);
        return new ResponseEntity<>(storeService.getItemById(itemId),HttpStatus.OK);
    }

    @DeleteMapping({"/{itemId}"})
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Long itemId){
        storeService.deleteById(itemId);
        return new ResponseEntity<>("Item Deleted!",HttpStatus.OK);
    }
}
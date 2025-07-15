package com.mvp.store.storeApp.controllers;


import com.mvp.store.storeApp.entities.Store;
import com.mvp.store.storeApp.services.StoreService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/store")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<?> getItem(@PathVariable Long itemId){
        Optional<Store> store = storeService.getItemById(itemId);
        if (store.isPresent()){
         return ResponseEntity.ok(store.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found: ID " + itemId);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Store> saveItem(@RequestBody Store store){
        Store store1 = storeService.insert(store);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("store", "/api/v1/store" + store1.getId().toString());
        return new ResponseEntity<>(store1, httpHeaders, HttpStatus.CREATED);
    }



    @PutMapping(value = "/{itemId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam("item_name") String itemName,
            @RequestParam("price") Float price,
            @RequestParam("quantity") Integer quantity
    ) {
        Store item = new Store();
        item.setItem_name(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        storeService.updateItem(itemId, item);

        return new ResponseEntity<>(storeService.getItemById(itemId), HttpStatus.OK);
    }


    @DeleteMapping({"/{itemId}"})
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Long itemId){
        storeService.deleteById(itemId);
        return new ResponseEntity<>("Item Deleted!",HttpStatus.NO_CONTENT);
    }
}
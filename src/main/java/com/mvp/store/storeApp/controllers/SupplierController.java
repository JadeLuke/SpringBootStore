package com.mvp.store.storeApp.controllers;


import com.mvp.store.storeApp.entities.Supplier;
import com.mvp.store.storeApp.services.SupplierService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {
    SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Supplier>> getAllSuppliers(){
        List<Supplier> suppliers = supplierService.getSupplier();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping({"/{supplierId}"})
    public ResponseEntity<?> getSupplier(@PathVariable Long supplierId){
        Optional<Supplier>supplier = supplierService.getSupplierById(supplierId);

        if (supplier.isPresent()){
            return ResponseEntity.ok(supplier.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Supplier Not found: ID " + supplierId);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier){
        Supplier supplier1 = supplierService.insert(supplier);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("supplier", "api/v1/supplier" + supplier1.getId().toString());
        return new ResponseEntity<>(supplier1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{supplierId}"})
    public ResponseEntity<Optional<Supplier>> updateSupplier(@PathVariable("supplierId") Long supplierId, @RequestBody Supplier supplier){
        supplierService.updateSupplier(supplierId, supplier);
        return new ResponseEntity<>(supplierService.getSupplierById(supplierId), HttpStatus.OK);
    }

    @DeleteMapping({"/{supplierId}"})
    public ResponseEntity<String> deleteSupplier(@PathVariable("supplierId") Long supplierId){
        supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>("Supplier deleted!", HttpStatus.NOT_FOUND);
    }
}



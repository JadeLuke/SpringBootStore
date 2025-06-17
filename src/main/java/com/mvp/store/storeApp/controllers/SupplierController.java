package com.mvp.store.storeApp.controllers;


import com.mvp.store.storeApp.entities.Supplier;
import com.mvp.store.storeApp.services.SupplierService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Supplier> getSupplier(@PathVariable Long supplierId){
        return new ResponseEntity<>(supplierService.getSupplierById(supplierId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier){
        Supplier supplier1 = supplierService.insert(supplier);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("supplier", "api/v1/supplier" + supplier1.getId().toString());
        return new ResponseEntity<>(supplier1, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{supplierId}"})
    public ResponseEntity<Supplier> updateSupplier(@PathVariable("supplierId") Long supplierId, @RequestBody Supplier supplier){
        supplierService.updateSupplier(supplierId, supplier);
        return new ResponseEntity<>(supplierService.getSupplierById(supplierId), HttpStatus.OK);
    }

    @DeleteMapping({"/{supplierId}"})
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable("supplierId") Long supplierId){
        supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



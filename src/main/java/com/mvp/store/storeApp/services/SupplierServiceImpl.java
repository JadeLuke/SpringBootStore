package com.mvp.store.storeApp.services;



import com.mvp.store.storeApp.entities.Store;
import com.mvp.store.storeApp.entities.Supplier;
import com.mvp.store.storeApp.repositories.StoreRepository;
import com.mvp.store.storeApp.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    @Override
    public List<Store> getItems() {
        List<Store> Items = new ArrayList<>();
        supplierRepository.findAll().forEach(Items::add);
        return Items;
    }
    @Override
    public Supplier getItemById(Long id) {
        return supplierRepository.findById(id).get();
    }
    @Override
    public Supplier insert(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    @Override
    public void updateItem
            (Long id, Store store) {
        Store itemsFromDb = supplierRepository.findById(id).get();
        System.out.println(itemsFromDb.toString());
        itemsFromDb.setItem_name(store.getItem_name());
        itemsFromDb.setPrice(store.getPrice());
        itemsFromDb.setQuantity(store.getQuantity());
        itemsFromDb.setSupplier(store.getSupplier());
        supplierRepository.save(itemsFromDb);
    }
    @Override
    public void deleteItem(Long itemId) {
       supplierRepository.deleteById(itemId);
    }}



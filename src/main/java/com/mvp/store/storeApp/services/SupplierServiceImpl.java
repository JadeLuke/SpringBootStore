package com.mvp.store.storeApp.services;




import com.mvp.store.storeApp.entities.Supplier;
import com.mvp.store.storeApp.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    @Override
    public List<Supplier> getSupplier() {
        List<Supplier> supplier = new ArrayList<>();
        supplierRepository.findAll().forEach(supplier::add);
        return supplier;
    }
    @Override
    public Optional <Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }
    @Override
    public Supplier insert(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    @Override
    public void updateSupplier
            (Long id, Supplier supplier) {
     Supplier supplierFromDb = supplierRepository.findById(id).get();
        System.out.println(supplierFromDb.toString());
     supplierFromDb.setName(supplier.getName());
      supplierFromDb.setContact(supplier.getContact());

        supplierRepository.save(supplierFromDb);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    }





package com.mvp.store.storeApp.repositories;

import com.mvp.store.storeApp.entities.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository <Store, Long> {

}

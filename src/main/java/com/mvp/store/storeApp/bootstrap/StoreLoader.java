package com.mvp.store.storeApp.bootstrap;

import com.mvp.store.storeApp.entities.Store;
import com.mvp.store.storeApp.repositories.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StoreLoader implements CommandLineRunner {

    private final StoreRepository storeRepository;

    public StoreLoader(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadStores();
    }

    private void loadStores() {
        if (storeRepository.count() == 0) {
            storeRepository.save(
                    Store.builder()
                            .item_name("Apple")
                            .price(3.99f)
                            .quantity(10)
                            .build()
            );

            storeRepository.save(
                    Store.builder()
                            .item_name("Banana")
                            .price(6.99f)
                            .quantity(20)
                            .build()
            );

            System.out.println("Sample Items Loaded");
        }
    }
}

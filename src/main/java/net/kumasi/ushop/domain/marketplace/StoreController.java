package net.kumasi.ushop.domain.marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping(path = "/add")
    public void addStore(@RequestBody Store store) {
        storeService.createStore(store);
    }

    @GetMapping(path = "/discounts")
    public List<Store> getDiscounts() {
        return storeService.getStores();
    }

    @GetMapping(path = "{id}")
    public Store findById(@PathVariable("id") Integer id) {
        return storeService.readStoreById(id);
    }

    @GetMapping(path = "{storeName}")
    public List<Store> findByName(@PathVariable("storeName") String storeName) throws Exception {
        List<Store> models = storeService.readByName(storeName);
        if(!models.isEmpty() && models.size() > 0) {
            throw new IllegalStateException("Store already on file");
        }
        return models;
    }

    @PutMapping(path = "/update")
    public void updateStore(@RequestBody Store store) {
        storeService.updateStore(store);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteStore(@PathVariable("id") Integer id) {
        Store store =  new Store();
        store.setId(id);
        storeService.deleteStore(store);
    }
}

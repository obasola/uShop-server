package net.kumasi.ushop.domain.marketplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepository repository;

    public List<Store> getStores() {
        List<Store> modelList = new ArrayList<>();
        List<StoreEntity>  entities = repository.findAll();
        try {
            StoreMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createStore(Store store) {
        int rc = -1;
        try{
            List<Store> storeList = this.readByName(store.getName());
            for(Store instance : storeList) {
                if(instance.getName().equals(store.getName()) &&
                   instance.getAddress().equals(store.getAddress() )) {
                    throw new IllegalStateException("Email address already on file");
                }
            }

            return saveStore(store);
        }catch(Exception e){ e.printStackTrace();}
        return rc;
    }
    public Store readStoreById(Integer id) {
        Store store = new Store();
        StoreEntity instance = null;
        Optional<StoreEntity> entity = repository.findById( id);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(store, instance);
        }
        return store;
    }

    public List<Store> readByName(String name) throws Exception {
        List<Store> stores = new ArrayList<>();
        Store store = new Store();
        store.setName(name);
        List<StoreEntity> instances = new ArrayList<>();
        List<Optional<StoreEntity>> entities = repository.findByName(store);
        for (Optional<StoreEntity> entity : entities) {
            if (entity.isPresent()) {
                instances.add(entity.get());
            }
            StoreMapper.mapToModel(stores,instances);
        }
        return stores;
    }
    public int updateStore(Store store) {
        return saveStore(store);
    }
    @Transactional
    public int deleteStore(Store store) {
        boolean exists = repository.existsById(store.getId());
        if(!exists) {
            throw new IllegalStateException("Store ID not on file so cannot delete it.");
        }
        repository.deleteById(store.getId());

        return 0;
    }
    @Transactional
    protected int saveStore(Store store) {
        StoreEntity instance =  new StoreEntity();
        int rc = mapDomain(instance, store);
        repository.save(instance);
        return rc;
    }

    private int mapModel(Store store, StoreEntity entity) {
        int rc = -1;
        try {
            StoreMapper.mapToModel(store, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
    private int mapDomain(StoreEntity entity, Store store) {
        int rc = -1;
        try {
            StoreMapper.mapToDomain(entity, store);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}

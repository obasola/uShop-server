package net.kumasi.ushop.domain.purchase;

import net.kumasi.ushop.domain.marketplace.StoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemListService {
    @Autowired
    private ItemListRepository repository;

    public List<ItemList> getItemLists() {
        List<ItemList> modelList = new ArrayList<>();
        List<ItemListEntity>  entities = repository.findAll();
        try {
            ItemListMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createItemList(ItemList item) {
        int rc = -1;
        try{
            List<ItemList> itemList = this.readByName(item.getItem());
            for(ItemList instance : itemList) {
                if(instance.getItem().equals(item.getItem()) ) {
                    throw new IllegalStateException("Item already on file");
                }
            }

            return saveItemList(item);
        }catch(Exception e){ e.printStackTrace();}
        return rc;
    }
    public ItemList readById(Integer id) {
        ItemList item = new ItemList();
        ItemListEntity instance = null;
        Optional<ItemListEntity> entity = repository.findById( id);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(item, instance);
        }
        return item;
    }

    public List<ItemList> readByName(String name) throws Exception {
        List<ItemList> items = new ArrayList<>();

        List<ItemListEntity> instances = new ArrayList<>();
        List<Optional<ItemListEntity>> entities = repository.findByItemName(name);
        for (Optional<ItemListEntity> entity : entities) {
            if (entity.isPresent()) {
                instances.add(entity.get());
            }
            ItemListMapper.mapToModel(items,instances);
        }
        return items;
    }

    public List<ItemList> readByStore(Integer storeId) throws Exception {
        List<ItemList> items = new ArrayList<>();

        List<ItemListEntity> instances = new ArrayList<>();
        List<Optional<ItemListEntity>> entities = repository.findByStore(storeId);
        for (Optional<ItemListEntity> entity : entities) {
            if (entity.isPresent()) {
                instances.add(entity.get());
            }
            ItemListMapper.mapToModel(items,instances);
        }
        return items;
    }

    public List<ItemList> readByOwner(Integer personId) throws Exception {
        List<ItemList> items = new ArrayList<>();

        List<ItemListEntity> instances = new ArrayList<>();
        List<Optional<ItemListEntity>> entities = repository.findByItemListOwner(personId);
        for (Optional<ItemListEntity> entity : entities) {
            if (entity.isPresent()) {
                instances.add(entity.get());
            }
            ItemListMapper.mapToModel(items,instances);
        }
        return items;
    }

    public List<ItemList> readByDiscount(Integer couponId) throws Exception {
        List<ItemList> items = new ArrayList<>();

        List<ItemListEntity> instances = new ArrayList<>();
        List<Optional<ItemListEntity>> entities = repository.findByCoupon(couponId);
        for (Optional<ItemListEntity> entity : entities) {
            if (entity.isPresent()) {
                instances.add(entity.get());
            }
            ItemListMapper.mapToModel(items,instances);
        }
        return items;
    }

    public int updateItemList(ItemList item) {
        return saveItemList(item);
    }
    @Transactional
    public int deleteItemList(ItemList item) {
        boolean exists = repository.existsById(item.getId());
        if(!exists) {
            throw new IllegalStateException("ItemList ID not on file so cannot delete it.");
        }
        repository.deleteById(item.getId());

        return 0;
    }
    @Transactional
    protected int saveItemList(ItemList item) {
        ItemListEntity instance =  new ItemListEntity();
        int rc = mapDomain(instance, item);
        repository.save(instance);
        return rc;
    }

    private int mapModel(ItemList item, ItemListEntity entity) {
        int rc = -1;
        try {
            ItemListMapper.mapToModel(item, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
    private int mapDomain(ItemListEntity entity, ItemList item) {
        int rc = -1;
        try {
            ItemListMapper.mapToDomain(entity, item);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
}

package net.kumasi.ushop.domain.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ItemListController {
    @Autowired
    private ItemListService itemListService;

    @PostMapping(path = "/add")
    public void addItemList(@RequestBody ItemList itemList) {
        itemListService.createItemList(itemList);
    }

    @GetMapping(path = "/items")
    public List<ItemList> getItems() {
        return itemListService.getItemLists();
    }

    @GetMapping(path = "{id}")
    public ItemList findById(@PathVariable("id") Integer id) {
        return itemListService.readById(id);
    }

    @GetMapping(path = "{itemListName}")
    public List<ItemList> findByName(@PathVariable("itemListName") String itemListName) throws Exception {
        List<ItemList> models = itemListService.readByName(itemListName);
        if(!models.isEmpty() && models.size() > 0) {
            throw new IllegalStateException("Item List already on file");
        }
        return models;
    }

    @PutMapping(path = "/update")
    public void updateItemList(@RequestBody ItemList itemList) {
        itemListService.updateItemList(itemList);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteItemList(@PathVariable("id") Integer id) {
        ItemList itemList =  new ItemList();
        itemList.setId(id);
        itemListService.deleteItemList(itemList);
    }
}

package net.kumasi.ushop.domain.purchase;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class ItemListMapper {
    public  static void mapToDomain(
            ItemListEntity domain,
            ItemList model
    ) throws Exception {
        BeanUtils.copyProperties(model, domain);
    }

    public static void mapToModel(
            ItemList destination,
            ItemListEntity source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<ItemList> modelList,
                                  List<ItemListEntity> domainList) throws Exception {
        for (ItemListEntity domain : domainList) {
            ItemList model = new ItemList();
            ItemListMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<ItemListEntity> domainList,
                                   List<ItemList> modelList) throws Exception {
        for (ItemList model : modelList) {
            ItemListEntity domain = new ItemListEntity();
            ItemListMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}

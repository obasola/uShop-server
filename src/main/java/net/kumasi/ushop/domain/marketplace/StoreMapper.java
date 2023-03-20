package net.kumasi.ushop.domain.marketplace;

import net.kumasi.ushop.domain.marketplace.Store;
import net.kumasi.ushop.domain.marketplace.StoreEntity;
import net.kumasi.ushop.domain.marketplace.StoreMapper;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class StoreMapper {
    public  static void mapToDomain(
            StoreEntity domain,
            Store model
    ) throws Exception {
        BeanUtils.copyProperties(model, domain);
    }

    public static void mapToModel(
            Store destination,
            StoreEntity source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<Store> modelList,
                                  List<StoreEntity> domainList) throws Exception {
        for (StoreEntity domain : domainList) {
            Store model = new Store();
            StoreMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<StoreEntity> domainList,
                                   List<Store> modelList) throws Exception {
        for (Store model : modelList) {
            StoreEntity domain = new StoreEntity();
            StoreMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}

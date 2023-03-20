package net.kumasi.ushop.domain.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemListRepository extends JpaRepository<ItemListEntity, Integer> {
    @Query("Select i from ItemListEntity i  where i.item = ?1")
    List<Optional<ItemListEntity>> findByItemName(String itemName);

    @Query("Select i from ItemListEntity i  where i.person.id = ?1")
    List<Optional<ItemListEntity>> findByItemListOwner(Integer personId);

    @Query("Select i from ItemListEntity i  where i.store.id = ?1")
    List<Optional<ItemListEntity>> findByStore(Integer storeId);

    @Query("Select i from ItemListEntity i  where i.coupon.id = ?1")
    List<Optional<ItemListEntity>> findByCoupon(Integer couponId);

}

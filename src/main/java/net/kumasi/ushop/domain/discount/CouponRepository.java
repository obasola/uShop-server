package net.kumasi.ushop.domain.discount;

import net.kumasi.ushop.domain.marketplace.StoreEntity;
import net.kumasi.ushop.domain.shopper.Person;
import net.kumasi.ushop.domain.shopper.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<CouponEntity, Integer> {
    @Query("Select p from CouponEntity p  where p.coupon = ?1")
    Optional<CouponEntity> findByCoupon(Coupon coupon);
}

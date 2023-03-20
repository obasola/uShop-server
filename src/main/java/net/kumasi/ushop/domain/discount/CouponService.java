package net.kumasi.ushop.domain.discount;

import net.kumasi.ushop.domain.shopper.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouponService {    @Autowired
private CouponRepository repository;

    public List<Coupon> getCoupons() {
        List<Coupon> modelList = new ArrayList<>();
        List<CouponEntity>  entities = repository.findAll();
        try {
            CouponMapper.mapToModel(modelList, entities);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return modelList;
    }
    public int createCoupon(Coupon coupon) {
        Optional<Coupon> modelOptional = Optional.ofNullable(this.readByCoupon(coupon.getCoupon()));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Coupon already on file");
        }
        return saveCoupon(coupon);
    }
    public Coupon readCouponById(Integer id) {
        Coupon coupon = new Coupon();
        CouponEntity instance = null;
        Optional<CouponEntity> entity = repository.findById( id);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(coupon, instance);
        }
        return coupon;
    }

    public Coupon readByCoupon(String coupon) {
        Coupon model = new Coupon();
        model.setCoupon(coupon);
        CouponEntity instance = null;
        Optional<CouponEntity> entity = repository.findByCoupon(model);

        if(entity.isPresent()) {
            instance = entity.get();
            mapModel(model, instance);
        }
        return model;
    }
    public int updateCoupon(Coupon coupon) {
        return saveCoupon(coupon);
    }
    @Transactional
    public int deleteCoupon(Coupon coupon) {
        boolean exists = repository.existsById(coupon.getId());
        if(!exists) {
            throw new IllegalStateException("Coupon ID not on file so cannot delete it.");
        }
        repository.deleteById(coupon.getId());

        return 0;
    }
    @Transactional
    protected int saveCoupon(Coupon coupon) {
        CouponEntity instance =  new CouponEntity();
        int rc = mapDomain(instance, coupon);
        repository.save(instance);
        return rc;
    }

    private int mapModel(Coupon coupon, CouponEntity entity) {
        int rc = -1;
        try {
            CouponMapper.mapToModel(coupon, entity);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
    private int mapDomain(CouponEntity entity, Coupon coupon) {
        int rc = -1;
        try {
            CouponMapper.mapToDomain(entity, coupon);
            rc = 1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rc;
    }
    
}

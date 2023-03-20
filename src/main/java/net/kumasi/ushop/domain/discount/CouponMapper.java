package net.kumasi.ushop.domain.discount;

import org.springframework.beans.BeanUtils;

import java.util.List;

public class CouponMapper {
    public  static void mapToDomain(
            CouponEntity domain,
            Coupon model
    ) throws Exception {
        BeanUtils.copyProperties(model, domain);
    }

    public static void mapToModel(
            Coupon destination,
            CouponEntity source
    ) throws Exception {
        BeanUtils.copyProperties(source, destination);
    }

    public static void mapToModel(List<Coupon> modelList,
                                  List<CouponEntity> domainList) throws Exception {
        for (CouponEntity domain : domainList) {
            Coupon model = new Coupon();
            CouponMapper.mapToDomain(domain, model);
            modelList.add(model);
        }
    }

    public static void mapToDomain(List<CouponEntity> domainList,
                                   List<Coupon> modelList) throws Exception {
        for (Coupon model : modelList) {
            CouponEntity domain = new CouponEntity();
            CouponMapper.mapToDomain(domain, model);
            domainList.add(domain);
        }
    }
}

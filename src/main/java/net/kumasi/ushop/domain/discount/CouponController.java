package net.kumasi.ushop.domain.discount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping(path = "/add")
    public void addCoupon(@RequestBody Coupon coupon) {
        couponService.createCoupon(coupon);
    }

    @GetMapping(path = "/discounts")
    public List<Coupon> getDiscounts() {
        return couponService.getCoupons();
    }

    @GetMapping(path = "{id}")
    public Coupon findById(@PathVariable("id") Integer id) {
        return couponService.readCouponById(id);
    }

    @GetMapping(path = "{couponName}")
    public Coupon findByName(@PathVariable("emacouponNameil") String couponName) throws IllegalStateException{
        Optional<Coupon> modelOptional = Optional.ofNullable(couponService.readByCoupon(couponName));
        if(modelOptional.isPresent()) {
            throw new IllegalStateException("Email address already on file");
        }
        return modelOptional.get();
    }

    @PutMapping(path = "/update")
    public void updateCoupon(@RequestBody Coupon coupon) {
        couponService.updateCoupon(coupon);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCoupon(@PathVariable("id") Integer id) {
        Coupon coupon =  new Coupon();
        coupon.setId(id);
        couponService.deleteCoupon(coupon);
    }
}

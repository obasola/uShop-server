package net.kumasi.ushop.domain.discount;

import java.util.Objects;

public class Coupon {
    private Integer id;
    private String coupon;
    private String barcode;
    private Float discount;

    public Coupon() {}
    public Coupon(String coupon, String barcode, Float discount) {
        loadProperties(null,coupon,barcode,discount);
    }

    public Coupon(Integer id, String coupon, String barcode, Float discount) {
       loadProperties(id,coupon,barcode,discount);
    }

    private void loadProperties(Integer id, String coupon, String barcode, Float discount) {
        this.id = id;
        this.coupon = coupon;
        this.barcode = barcode;
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon coupon1)) return false;
        return coupon.equals(coupon1.coupon) && discount.equals(coupon1.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coupon, discount);
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", coupon='" + coupon + '\'' +
                ", barcode='" + barcode + '\'' +
                ", discount=" + discount +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}

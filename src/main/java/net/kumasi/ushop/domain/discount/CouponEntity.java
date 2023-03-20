package net.kumasi.ushop.domain.discount;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kumasi.ushop.domain.purchase.ItemListEntity;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@RestResource
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Coupon")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "coupon", nullable = false, length = 100)
    private String coupon;

    @Column(name = "barcode", length = 45)
    private String barcode;

    @Column(name = "discount", nullable = false, precision = 5, scale = 2)
    private BigDecimal discount;

    @OneToMany(mappedBy = "coupon")
    private Set<ItemListEntity> itemLists = new LinkedHashSet<>();

    public Integer getId() {
        return id;
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

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Set<ItemListEntity> getItemLists() {
        return itemLists;
    }

    public void setItemLists(Set<ItemListEntity> itemLists) {
        this.itemLists = itemLists;
    }

}

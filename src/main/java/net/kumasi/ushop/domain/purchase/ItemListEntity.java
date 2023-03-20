package net.kumasi.ushop.domain.purchase;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kumasi.ushop.domain.discount.CouponEntity;
import net.kumasi.ushop.domain.shopper.PersonEntity;
import net.kumasi.ushop.domain.marketplace.StoreEntity;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@RestResource
@FieldDefaults(level = AccessLevel.PRIVATE)
    @Table(name = "Item_List")
    public class ItemListEntity {
        @EmbeddedId
        private ItemListEntityId id;

        @MapsId("storeId")
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "Store_id", nullable = false)
        private StoreEntity store;

        @Column(name = "item", nullable = false, length = 45)
        private String item;

        @Column(name = "recurring")
        private Short recurring;

        @Column(name = "date_recorded", nullable = false)
        private LocalDate dateRecorded;

        @Column(name = "price", nullable = false, precision = 5, scale = 2)
        private BigDecimal price;

        @Column(name = "aisle", length = 45)
        private String aisle;

        @Column(name = "barcode", length = 100)
        private String barcode;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "Coupon_id", nullable = false)
        private CouponEntity coupon;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "Person_id", nullable = false)
        private PersonEntity person;

        public ItemListEntityId getId() {
            return id;
        }

        public void setId(ItemListEntityId id) {
            this.id = id;
        }

        public StoreEntity getStore() {
            return store;
        }

        public void setStore(StoreEntity store) {
            this.store = store;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Short getRecurring() {
            return recurring;
        }

        public void setRecurring(Short recurring) {
            this.recurring = recurring;
        }

        public LocalDate getDateRecorded() {
            return dateRecorded;
        }

        public void setDateRecorded(LocalDate dateRecorded) {
            this.dateRecorded = dateRecorded;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getAisle() {
            return aisle;
        }

        public void setAisle(String aisle) {
            this.aisle = aisle;
        }

        public String getBarcode() {
            return barcode;
        }

        public void setBarcode(String barcode) {
            this.barcode = barcode;
        }

        public CouponEntity getCoupon() {
            return coupon;
        }

        public void setCoupon(CouponEntity coupon) {
            this.coupon = coupon;
        }

        public PersonEntity getPerson() {
            return person;
        }

        public void setPerson(PersonEntity person) {
            this.person = person;
        }

    }

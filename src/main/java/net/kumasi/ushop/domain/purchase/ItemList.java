package net.kumasi.ushop.domain.purchase;

import java.util.Date;
import java.util.Objects;

public class ItemList {
    private Integer id;
    private String item;
    private int recurring;
    private Date date_recorded;
    private Float price;
    private String aisle;
    private String barcode;
    private Integer storeId;
    private Integer couponId;
    private Integer personId;

    public ItemList() {}
    public ItemList(String item, int recurring, Date date_recorded, Float price, String aisle, String barcode, Integer storeId, Integer couponId, Integer personId) {
        loadProperties(null,   item, recurring, date_recorded, price, aisle, barcode, storeId, couponId, personId);
    }

    public ItemList(Integer id, String item, int recurring, Date date_recorded, Float price, String aisle, String barcode, Integer storeId, Integer couponId, Integer personId) {
        loadProperties(id,   item, recurring, date_recorded, price, aisle, barcode, storeId, couponId, personId);
    }

    private void loadProperties(Integer id, String item, int recurring, Date date_recorded, Float price, String aisle, String barcode, Integer storeId, Integer couponId, Integer personId){
        this.id = id;
        this.item = item;
        this.recurring = recurring;
        this.date_recorded = date_recorded;
        this.price = price;
        this.aisle = aisle;
        this.barcode = barcode;
        this.storeId = storeId;
        this.couponId = couponId;
        this.personId = personId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getRecurring() {
        return recurring;
    }

    public void setRecurring(int recurring) {
        this.recurring = recurring;
    }

    public Date getDate_recorded() {
        return date_recorded;
    }

    public void setDate_recorded(Date date_recorded) {
        this.date_recorded = date_recorded;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemList itemList)) return false;
        return item.equals(itemList.item) && date_recorded.equals(itemList.date_recorded) && storeId.equals(itemList.storeId) && personId.equals(itemList.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, date_recorded, storeId, personId);
    }

    @Override
    public String toString() {
        return "ItemList{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", recurring=" + recurring +
                ", date_recorded=" + date_recorded +
                ", price=" + price +
                ", aisle='" + aisle + '\'' +
                ", barcode='" + barcode + '\'' +
                ", storeId=" + storeId +
                ", couponId=" + couponId +
                ", personId=" + personId +
                '}';
    }
}

package net.kumasi.ushop.domain.marketplace;

import java.util.Objects;

public class Store {
    private Integer id;
    private String name;
    private String website;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String phone;

    public Store() {}
    public Store(String name, String website, String address, String city, String state, String zipcode, String phone) {
        loadProperties(null,name,website,address,city,state,zipcode,phone);
    }

    public Store(Integer id, String name, String website, String address, String city, String state, String zipcode, String phone) {
        loadProperties(id,name,website,address,city,state,zipcode,phone);
    }

    private void loadProperties(Integer id, String name, String website, String address, String city, String state, String zipcode, String phone) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store store)) return false;
        return name.equals(store.name) && address.equals(store.address) && city.equals(store.city) && state.equals(store.state) && zipcode.equals(store.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, city, state, zipcode);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

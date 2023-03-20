package net.kumasi.ushop.domain.marketplace;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.kumasi.ushop.domain.purchase.ItemListEntity;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


@Data
@Entity
@NoArgsConstructor
@RestResource
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="Store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "website", length = 75)
    private String website;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "city", length = 45)
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "zipcode", length = 5)
    private String zipcode;

    @Column(name = "phone", length = 11)
    private String phone;

    @OneToMany(mappedBy = "store")
    private Set<ItemListEntity> itemLists = new LinkedHashSet<>();

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

    public Set<ItemListEntity> getItemLists() {
        return itemLists;
    }

    public void setItemLists(Set<ItemListEntity> itemLists) {
        this.itemLists = itemLists;
    }

}
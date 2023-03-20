package net.kumasi.ushop.domain.shopper;

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
@Table(name = "Person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @OneToMany(mappedBy = "person")
    private Set<ItemListEntity> itemLists = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ItemListEntity> getItemLists() {
        return itemLists;
    }

    public void setItemLists(Set<ItemListEntity> itemLists) {
        this.itemLists = itemLists;
    }

}
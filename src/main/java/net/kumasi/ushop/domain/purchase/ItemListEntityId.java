package net.kumasi.ushop.domain.purchase;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemListEntityId implements Serializable {
    private static final long serialVersionUID = -8973215620981204964L;
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "Store_id", nullable = false)
    private Integer storeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemListEntityId entity = (ItemListEntityId) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.storeId, entity.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeId);
    }

}
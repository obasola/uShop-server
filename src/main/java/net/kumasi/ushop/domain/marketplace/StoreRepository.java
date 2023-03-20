package net.kumasi.ushop.domain.marketplace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {
        @Query("Select p from StoreEntity p  where p.name = ?1")
        List<Optional<StoreEntity>> findByName(Store store);
}

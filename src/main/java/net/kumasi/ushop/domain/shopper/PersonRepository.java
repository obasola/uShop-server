package net.kumasi.ushop.domain.shopper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    @Query("Select p from PersonEntity p  where p.email = ?1")
    Optional<PersonEntity> findByEmail(Person person);
}

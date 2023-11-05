package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

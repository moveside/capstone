package moveside.domain.Repository;

import moveside.domain.Entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("SELECT code From Store")
    List<String> findAllCode();
    @Query("SELECT s FROM Store s WHERE s.code =?1")
    Store findCode(String code);
}

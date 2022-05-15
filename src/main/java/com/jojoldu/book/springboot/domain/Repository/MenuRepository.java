package com.jojoldu.book.springboot.domain.Repository;

import com.jojoldu.book.springboot.domain.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu,Long> {
    @Query("SELECT p From Menu p Where p.store= ?1 ORDER BY p.id DESC")
    List<Menu> findAllDesc(String store);
}

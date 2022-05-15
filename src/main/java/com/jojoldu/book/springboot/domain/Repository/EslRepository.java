package com.jojoldu.book.springboot.domain.Repository;

import com.jojoldu.book.springboot.domain.Entity.ESL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EslRepository extends JpaRepository<ESL,Long> {

}

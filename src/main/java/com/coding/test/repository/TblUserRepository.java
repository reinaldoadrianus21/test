package com.coding.test.repository;

import com.coding.test.entity.TBL_USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblUserRepository extends JpaRepository<TBL_USER, String> {
    List<TBL_USER> findAllByUserid(Integer userId);
    TBL_USER findTopByUsername(String username);

    TBL_USER findTopByUserid(Integer userId);
}

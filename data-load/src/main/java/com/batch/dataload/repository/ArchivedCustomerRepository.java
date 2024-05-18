package com.batch.dataload.repository;

import com.batch.dataload.entity.ArchivedCustomerEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArchivedCustomerRepository extends JpaRepository<ArchivedCustomerEntity, Long> {

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT a FROM ArchivedCustomerEntity a")
//    @Query(nativeQuery = true, value = "SELECT * FROM HISTORICAL_CUSTOMER_INFORMATION LIMIT 5 FOR UPDATE")
    public List<ArchivedCustomerEntity> findTopX();

}

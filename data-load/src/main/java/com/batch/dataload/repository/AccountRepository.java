package com.batch.dataload.repository;

import com.batch.dataload.entity.AccountEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Transactional()
    @Query("SELECT a FROM AccountEntity a WHERE a.id = :id")
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<AccountEntity> findAnAccount(@Param("id") Long id);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional()
    @Query("UPDATE AccountEntity a SET a.balance = :balance WHERE a.id = :id")
    void updateAccountBalance(@Param("balance") Integer balance, @Param("id") Long id);
}

package com.database.understandingjpa.repository.user;

import com.database.understandingjpa.entity.user.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    @Override
    @NonNull
    @Query("select e from EmployeeEntity e left join fetch e.employees where e.id = :id")
    Optional<EmployeeEntity> findById(@Param("id") @NonNull Long id);
}

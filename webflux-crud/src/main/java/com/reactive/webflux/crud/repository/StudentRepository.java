package com.reactive.webflux.crud.repository;

import com.reactive.webflux.crud.entity.StudentEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends R2dbcRepository<StudentEntity, Long> {
}

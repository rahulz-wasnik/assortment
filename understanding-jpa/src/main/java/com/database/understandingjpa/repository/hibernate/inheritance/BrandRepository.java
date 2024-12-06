package com.database.understandingjpa.repository.hibernate.inheritance;

import com.database.understandingjpa.entity.hibernate.inheritance.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}

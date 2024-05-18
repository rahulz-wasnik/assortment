package com.database.understandingjpa.repository.brand;

import com.database.understandingjpa.entity.brand.HuskyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    Will only save husky properties like to husky table even when husky object is passed to its save all
    nothing will be saved to the dog or the animal table
*/
public interface HuskyRepository extends JpaRepository<HuskyEntity, Long> {
}

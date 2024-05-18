package com.database.understandingjpa.repository.brand;

import com.database.understandingjpa.entity.brand.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
Will only save animal properties like 'category' to animal table even when husky object is passed to its save all
nothing will be saved to the husky table
 */
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}

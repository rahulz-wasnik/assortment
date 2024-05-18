package com.database.understandingjpa.controller.brand;

import com.database.understandingjpa.entity.brand.BrandEntity;
import com.database.understandingjpa.entity.brand.I10Entity;
import com.database.understandingjpa.repository.brand.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @PostMapping
    public ResponseEntity<BrandEntity> save(@RequestBody I10Entity brand) {
        return ResponseEntity.ok(brandRepository.save(brand));
    }
}

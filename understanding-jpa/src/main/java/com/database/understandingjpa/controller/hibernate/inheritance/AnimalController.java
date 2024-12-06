package com.database.understandingjpa.controller.hibernate.inheritance;

import com.database.understandingjpa.entity.hibernate.inheritance.AnimalEntity;
import com.database.understandingjpa.entity.hibernate.inheritance.HuskyEntity;
import com.database.understandingjpa.repository.hibernate.inheritance.AnimalRepository;
import com.database.understandingjpa.repository.hibernate.inheritance.HuskyRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animals")
public class AnimalController implements InitializingBean, DisposableBean {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private HuskyRepository huskyRepository;

    @PostMapping
    public ResponseEntity<AnimalEntity> save(@RequestBody AnimalEntity animal) {
        return ResponseEntity.ok(animalRepository.save(animal));
    }

    @PostMapping("/dogs/husky")
    public ResponseEntity<AnimalEntity> saveHusky(@RequestBody HuskyEntity husky) {
        return ResponseEntity.ok(huskyRepository.save(husky));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post construct");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("preDestroy");
    }
}

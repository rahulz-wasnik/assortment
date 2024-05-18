package com.reactive.webflux.crud.service;

import com.github.javafaker.Faker;
import com.reactive.webflux.crud.entity.StudentEntity;
import com.reactive.webflux.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private Faker faker;

    public Flux<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }

    public Mono<StudentEntity> saveStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    public Mono<StudentEntity> updateStudent(StudentEntity student, Long id) {

        return studentRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("Student does not exists")))
                .flatMap(savedStudent -> {
                    savedStudent.setName(student.getName());
                    return studentRepository.save(savedStudent);
                });
    }

    public Flux<StudentEntity> saveManyStudents() {

        studentRepository.deleteAll();

        List<StudentEntity> students = new ArrayList<>();

        for(int i = 0; i <= 1000; i++) {
            students.add(StudentEntity.builder().name(faker.name().name()).rollNumber(faker.random().nextInt(0, 10)).build());
        }

        return studentRepository.saveAll(students);
    }
}

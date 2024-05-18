package com.reactive.webflux.crud.controller;

import com.reactive.webflux.crud.entity.StudentEntity;
import com.reactive.webflux.crud.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<Flux<StudentEntity>> getAll() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<Mono<StudentEntity>> save(@RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<StudentEntity>> update(@PathVariable Long id, @RequestBody StudentEntity student) {
        return ResponseEntity.ok(studentService.updateStudent(student, id));
    }

    @PostMapping("/create-many-students-in-db")
    public ResponseEntity<Flux<StudentEntity>> saveManyStudents() {
        return ResponseEntity.ok(studentService.saveManyStudents());
    }
}

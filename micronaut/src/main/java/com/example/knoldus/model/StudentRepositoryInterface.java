package com.example.knoldus.model;

import com.example.knoldus.model.Student;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface StudentRepositoryInterface extends CrudRepository<Student, Integer> {
}

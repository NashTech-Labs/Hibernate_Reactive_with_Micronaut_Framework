package com.example.knoldus;

import com.example.knoldus.model.Student;
import com.example.knoldus.model.StudentRepositoryInterface;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
class StudentControllerTest {

    @Inject
    StudentRepositoryInterface studentRepositoryInterface;

    void createStudent(){
        studentRepositoryInterface.save(new Student(null, "Steven", "Adams", 1));
        studentRepositoryInterface.save(new Student(null, "Bill", "Gordon", 1));
    }

    @Test
    void read() {
        createStudent();
        Iterable<Student> all = studentRepositoryInterface.findAll();
        all.forEach(System.out::println);
    }
}
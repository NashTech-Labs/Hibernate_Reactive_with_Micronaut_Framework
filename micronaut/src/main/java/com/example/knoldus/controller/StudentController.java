package com.example.knoldus.controller;

import com.example.knoldus.model.StudentRepositoryInterface;
import com.example.knoldus.model.Student;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Controller(value="/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepositoryInterface student;

    @Get("/read")
    public Iterable<Student> read(){
        return student.findAll();
    }

    @Delete("/delete/{id}")
    public Student delete(@PathVariable Integer id){
        Optional<Student> byId = student.findById(id);
        if (byId.isEmpty())
            throw new IllegalArgumentException("Does not exist: " + id);
        student.delete(byId.get());
        return byId.get();
    }

    @Post("/create")
    public Student createWithBody(@Body Student student){
                return this.student.save(student);
    }

    @Post("/update")
    public Student updateWithBody(@Body Student student){
      Optional<Student> studentByRoll = this.student.findById(student.getRoll());
      Student entity = studentByRoll.get();
      entity.setLastName(student.getLastName());
      entity.setStandard(student.getStandard());
      entity.setFirstName(student.getFirstName());
      return this.student.update(entity);
    }

}

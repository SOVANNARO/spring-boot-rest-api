package org.tutorials.springbootrestapi.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tutorials.springbootrestapi.bean.Student;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "John",
                "Doe"
        );

        return ResponseEntity.ok()
                .header("custom-header", "naro")
                .body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<Student[]> getStudents() {
        Student[] students = new Student[] {
                new Student(
                        1,
                        "John",
                        "Doe"
                ),
                new Student(
                        2,
                        "Jane",
                        "Doe"
                )
        };

        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
        Student student = new Student(
                id,
                "John",
                "Doe"
        );

        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED)
               .body(student);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int id) {
        return ResponseEntity.ok("Student with id: " + id + " deleted");
    }
}

package edu.miu.cs.cs425.mystudentmgmtappwebapi.controller;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value={"/studentMgmt/api/v1/student"})
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value ={"/list"})
    public ResponseEntity<List<Student>> listStudent() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value ={"/get/{studentId}"})
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping(value = {"/new"})
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.addNewStudent(studentRequest),
                HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{studentId}"})
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest,
                                                 @PathVariable Long studentId){
        return new ResponseEntity<>(studentService.updateStudent(studentRequest, studentId),
        HttpStatus.OK);
    }

    @DeleteMapping (value = {"/delete/{studentId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = {"/search/{nameStart}"})
    public ResponseEntity<Student> searchStudentByFirstName(@PathVariable String nameStart){
        return ResponseEntity.ok(studentService.searchStudentByName(nameStart));
    }


}

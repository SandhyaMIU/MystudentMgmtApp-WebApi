package edu.miu.cs.cs425.mystudentmgmtappwebapi.service;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student newStudent);

    Student addNewStudent(StudentRequest newStudentRequest);

    List<Student> getAllStudents();


    Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student updateStudentById(Long studentId, Student editedStudent);

//    Student updateStudent(Student student);


    //    public Student updateStudent(Student student) {
    //        return studentRepository.save(student);
    //    }
    Student updateStudent(StudentRequest updatedStudentReq, Long studentId);

    void deleteStudentById(Long studentId);

    Student searchStudentByName(String nameStart);



}

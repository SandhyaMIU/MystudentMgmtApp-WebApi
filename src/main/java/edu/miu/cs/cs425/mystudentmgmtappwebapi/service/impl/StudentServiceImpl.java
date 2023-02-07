package edu.miu.cs.cs425.mystudentmgmtappwebapi.service.impl;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student addNewStudent(StudentRequest newStudentRequest) {
        var newStudent = new Student(null, newStudentRequest.getStudentNumber(),newStudentRequest.getFirstName(),
                newStudentRequest.getMiddleName(),newStudentRequest.getLastName(),newStudentRequest.getCgpa(),
                newStudentRequest.getDateOfEnrollment(),newStudentRequest.isInternalional());
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student with Id: %d is not found.",studentId)));
    }

    @Override
    public Student updateStudentById(Long studentId, Student editedStudent) {

        var theStudent = studentRepository.findById(studentId).orElse(null);
        Student updatedStudent = null;
        if(theStudent != null){
            theStudent.setMiddleName(editedStudent.getMiddleName());
            theStudent.setFirstName(editedStudent.getFirstName());
            /*theStudent.setPrimaryTranscript(editedStudent.getPrimaryTranscript());
            theStudent.setClassroom(editedStudent.getClassroom());*/
            updatedStudent = studentRepository.save(theStudent);
        }
        return updatedStudent;
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudentById(Long studentId) {
            studentRepository.deleteById(studentId);
    }
}

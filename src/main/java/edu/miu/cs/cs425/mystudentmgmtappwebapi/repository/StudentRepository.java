package edu.miu.cs.cs425.mystudentmgmtappwebapi.repository;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
    List<Student> searchStudentByStudentNumberOrFirstNameOrLastNameOrMiddleName(String searchValue1, String searchValue2, String searchValue3, String searchValue4);

    @Query(value = "select * from students p where p.first_name like %?1%", nativeQuery = true)
    Optional<Student> getStudentWhereFirstNameStartsWith(String nameStart);

}

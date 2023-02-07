package edu.miu.cs.cs425.mystudentmgmtappwebapi.repository;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends ListCrudRepository<Student, Long> {
}

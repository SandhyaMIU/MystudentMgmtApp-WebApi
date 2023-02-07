package edu.miu.cs.cs425.mystudentmgmtappwebapi.repository;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {
}

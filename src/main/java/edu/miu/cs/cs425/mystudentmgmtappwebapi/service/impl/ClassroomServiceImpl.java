package edu.miu.cs.cs425.mystudentmgmtappwebapi.service.impl;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.repository.ClassroomRepository;
import edu.miu.cs.cs425.mystudentmgmtappwebapi.service.ClassroomService;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    private ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public Classroom addNewClassroom(Classroom newClassroom) {
        return classroomRepository.save(newClassroom);
    }

    @Override
    public Classroom saveClassroom(Classroom newClassroom) {
        return classroomRepository.save(newClassroom);
    }


}

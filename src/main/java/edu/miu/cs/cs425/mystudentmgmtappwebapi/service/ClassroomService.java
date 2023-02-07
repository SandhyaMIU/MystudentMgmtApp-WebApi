package edu.miu.cs.cs425.mystudentmgmtappwebapi.service;

import edu.miu.cs.cs425.mystudentmgmtappwebapi.model.Classroom;

public interface ClassroomService {

    public Classroom addNewClassroom(Classroom newClassroom);

    Classroom saveClassroom(Classroom newClassroom);


}

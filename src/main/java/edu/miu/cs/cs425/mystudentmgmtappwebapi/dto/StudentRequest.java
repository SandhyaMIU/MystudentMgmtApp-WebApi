package edu.miu.cs.cs425.mystudentmgmtappwebapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "Student number cannot be blank or empty or null")
    private String studentNumber;

    @NotBlank(message = "Student FirstName cannot be blank or empty or null")
    private String firstName;
    private String middleName;

    @NotBlank(message = "Student LastName cannot be blank or empty or null")
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    private boolean isInternalional;


}

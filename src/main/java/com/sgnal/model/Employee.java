package com.sgnal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    //@NotNull--->@NotNull
    //@NotEmpty--> @NotNull + @NotEmpty
    //@NotBlank-->@NotNull + @NotEmpty + @NotBlank


    @NotBlank
    @Size(max=12,min=2)
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;


}

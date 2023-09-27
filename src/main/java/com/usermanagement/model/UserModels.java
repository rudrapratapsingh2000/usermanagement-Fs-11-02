package com.usermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "user")
public class UserModels {
    @Id
//    @NotNull
    private Integer userId;
    @NotBlank
    private String userName;
    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Invalid date of birth format. It should be in dd-MM-yyyy format.")
    private String dateOfBirth;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2}\\d{10}$", message = "Invalid phone number format")
    @Size(min = 12, max = 12, message = "Phone number length should be 12 digits")
    private String phoneNumber;
}

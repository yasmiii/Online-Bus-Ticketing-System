package com.ticketbooking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private long id;
    @Email(message="enter a valid email address")
    @NotNull(message="enter a valid email address")
    @NotBlank(message="enter a valid email address")
    private String email;
    private String password;
    @NotNull(message="enter a valid first name")
    @NotBlank(message="enter a valid first name")
    private String first_name;
    @NotNull(message="enter a valid last name")
    @NotBlank(message="enter a valid last name")
    private String last_name;
    @Pattern(regexp = "^([0-9]{9}[x|X|v|V]|[0-9]{12})$", message="enter a valid nic number")
    private String nic;
    private String type;
    @Pattern(regexp = "^\\d{10}$", message="enter a valid mobile number")
    private String mobile;
    private String status;
}

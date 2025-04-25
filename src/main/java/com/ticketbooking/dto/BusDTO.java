package com.ticketbooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {
    private long id;
    @Pattern(regexp = "^([A-Z]{2,3}|[0-9]{4})$", message="enter a valid registration number")
    private String registration_no;
    @NotNull(message="enter a valid owner id")
    @NotBlank(message="enter a valid owner id")
    private long owner_id;
    private String status;
    private String type;
}

package com.ticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {
    private long id;
    private long bus_id;
    private long driver_id;
    private long conductor_id;
    private String departure_time;
    private String departure_location;
    private String arrival_time;
    private String arrival_location;
    private String status;
}

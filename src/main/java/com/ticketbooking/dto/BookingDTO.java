package com.ticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private long id;
    private long schedule_id;
    private String date;
    private int seat_no;
    private long user_id;
    private String pickup;
    private String destination;
    private String status;
}

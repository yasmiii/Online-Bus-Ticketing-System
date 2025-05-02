package com.ticketbooking.controller;


import com.ticketbooking.dto.BookingDTO;
import com.ticketbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/addBooking")
    public BookingDTO addBooking(@RequestBody BookingDTO bookingDTO){
        bookingDTO.setStatus("Active");
        return bookingService.addBooking(bookingDTO);
    }
    @GetMapping(value = "/viewBookings")
    public List<BookingDTO> viewBookings(){
        return bookingService.viewBookings();
    }
    @GetMapping(value = "/searchBookings")
    public List<BookingDTO> searchBookings(@RequestBody BookingDTO bookingDTO){
        return bookingService.searchBookingsByDateAndSchedule_id(bookingDTO);
    }
    @GetMapping(value = "/viewBooking/{id}")
    public BookingDTO viewBooking(@PathVariable int id){
        return bookingService.viewBooking(id);
    }
    @PutMapping(value = "/updateBooking")
    public BookingDTO updateBooking(@RequestBody BookingDTO bookingDTO){
        return bookingService.updateBooking(bookingDTO);
    }

    @PutMapping(value = "/deleteBooking/{id}")
    public boolean deleteBooking(@PathVariable String id){
        return bookingService.deleteBookingById(id);
    }
}

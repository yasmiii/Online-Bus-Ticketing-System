package com.ticketbooking.service;

import com.ticketbooking.dto.BookingDTO;
import com.ticketbooking.entity.Booking;
import com.ticketbooking.repo.BookingRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private ModelMapper modelMapper;
    public BookingDTO addBooking(BookingDTO bookingDTO){
        bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        return bookingDTO;
    }
    public List<BookingDTO> searchBookingsByDateAndSchedule_id(BookingDTO bookingDTO){
        List<Booking> bookings = bookingRepo.searchBookingsByDateAndSchedule_id(bookingDTO.getSchedule_id(), bookingDTO.getDate());
        return modelMapper.map(bookings, new TypeToken<List<BookingDTO>>(){}.getType());
    }
    public List<BookingDTO> viewBookings(){
        List<Booking> bookingList = bookingRepo.findAll();
        return modelMapper.map(bookingList, new TypeToken<List<BookingDTO>>(){}.getType());
    }
    public BookingDTO viewBooking(int id){
        return modelMapper.map(bookingRepo.getById(id), BookingDTO.class);
    }
    public BookingDTO updateBooking(BookingDTO bookingDTO){
        BookingDTO existingBooking = viewBooking((int) bookingDTO.getId());
        bookingDTO.setStatus(existingBooking.getStatus());
        bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        return bookingDTO;
    }
    public boolean deleteBookingById(String id){
        bookingRepo.deleteBookingById(id);
        return true;
    }
}

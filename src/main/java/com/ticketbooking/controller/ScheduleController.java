package com.ticketbooking.controller;

import com.ticketbooking.dto.ScheduleDTO;
import com.ticketbooking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/schedule")
@CrossOrigin
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping(value = "/addSchedule")
    public ScheduleDTO addSchedule(@RequestBody ScheduleDTO scheduleDTO){
        scheduleDTO.setStatus("Active");
        return scheduleService.addSchedule(scheduleDTO);
    }
    @GetMapping(value = "/viewSchedules")
    public List<ScheduleDTO> viewSchedules(){
        return scheduleService.viewSchedules();
    }
    @GetMapping(value = "/viewSchedule/{id}")
    public ScheduleDTO viewSchedule(@PathVariable int id){
        return scheduleService.viewSchedule(id);
    }
    @PutMapping(value = "/updateSchedule")
    public ScheduleDTO updateSchedule(@RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.updateSchedule(scheduleDTO);
    }

    @PutMapping(value = "/deleteSchedule/{id}")
    public boolean deleteSchedule(@PathVariable String id){
        return scheduleService.deleteScheduleById(id);
    }
}

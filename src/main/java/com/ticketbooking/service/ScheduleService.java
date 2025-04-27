package com.ticketbooking.service;

import com.ticketbooking.dto.ScheduleDTO;
import com.ticketbooking.entity.Schedule;
import com.ticketbooking.repo.ScheduleRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ScheduleDTO addSchedule(ScheduleDTO scheduleDTO){
        scheduleRepo.save(modelMapper.map(scheduleDTO, Schedule.class));
        return scheduleDTO;
    }
    public List<ScheduleDTO> viewSchedules(){
        List<Schedule> scheduleList = scheduleRepo.findAll();
        return modelMapper.map(scheduleList, new TypeToken<List<ScheduleDTO>>(){}.getType());
    }
    public ScheduleDTO viewSchedule(int id){
        return modelMapper.map(scheduleRepo.getById(id), ScheduleDTO.class);
    }
    public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO){
        ScheduleDTO existingSchedule = viewSchedule((int) scheduleDTO.getId());
        scheduleDTO.setStatus(existingSchedule.getStatus());
        scheduleRepo.save(modelMapper.map(scheduleDTO, Schedule.class));
        return scheduleDTO;
    }
    public boolean deleteScheduleById(String id){
        scheduleRepo.deleteScheduleById(id);
        return true;
    }
}

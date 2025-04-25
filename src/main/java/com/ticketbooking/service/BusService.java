package com.ticketbooking.service;

import com.ticketbooking.dto.BusDTO;
import com.ticketbooking.entity.Bus;
import com.ticketbooking.repo.BusRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusService {
    @Autowired
    private BusRepo busRepo;
    @Autowired
    private ModelMapper modelMapper;

    public BusDTO addBus(BusDTO busDTO){
        busRepo.save(modelMapper.map(busDTO, Bus.class));
        return busDTO;
    }
    public List<BusDTO> viewBuses(){
        List<Bus> busList = busRepo.findAll();
        return modelMapper.map(busList, new TypeToken<List<BusDTO>>(){}.getType());
    }
    public BusDTO viewBus(int id){
        return modelMapper.map(busRepo.getById(id), BusDTO.class);
    }
    public BusDTO updateBus(BusDTO busDTO){
        BusDTO existingBus = viewBus((int) busDTO.getId());
        busDTO.setStatus(existingBus.getStatus());
        busRepo.save(modelMapper.map(busDTO, Bus.class));
        return busDTO;
    }
    public boolean deleteBusById(String id){
        busRepo.deleteBusById(id);
        return true;
    }

    public List<BusDTO> viewMyBuses(int id) {
        List<Bus> busList = busRepo.getByOwnerId(id);
        return modelMapper.map(busList, new TypeToken<List<BusDTO>>(){}.getType());
    }
}

package com.ticketbooking.controller;

import com.ticketbooking.dto.BusDTO;
import com.ticketbooking.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bus")
@CrossOrigin
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping(value = "/addBus")
    public BusDTO addBus(@Valid @RequestBody BusDTO busDTO){
        busDTO.setStatus("Active");
        return busService.addBus(busDTO);
    }
    @GetMapping(value = "/viewBuses")
    public List<BusDTO> viewBuses(){
        return busService.viewBuses();
    }
    @GetMapping(value = "/viewMyBuses/{id}")
    public List<BusDTO> viewMyBuses(@PathVariable int id){
        return busService.viewMyBuses(id);
    }
    @GetMapping(value = "/viewBus/{id}")
    public BusDTO viewBus(@PathVariable int id){
        return busService.viewBus(id);
    }
    @PutMapping(value = "/updateBus")
    public BusDTO updateBus(@RequestBody BusDTO busDTO){
        return busService.updateBus(busDTO);
    }

    @PutMapping(value = "/deleteBus/{id}")
    public boolean deleteBus(@PathVariable String id){
        return busService.deleteBusById(id);
    }

}

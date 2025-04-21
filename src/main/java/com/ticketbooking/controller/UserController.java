package com.ticketbooking.controller;

import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/login")
    public UserDTO userLogin(@Valid @RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }
    @PostMapping(value = "/addUser")
    public UserDTO addUser(@Valid @RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }
    @GetMapping(value = "/viewUsers")
    public List<UserDTO> viewUsers(){
        return userService.viewUsers();
    }
    @GetMapping(value = "/viewUser/{id}")
    public ResponseEntity<UserDTO> viewUser(@PathVariable int id) {
        return new ResponseEntity<>(userService.viewUser(id), HttpStatus.OK);
    }
    @PutMapping(value = "/updateUser")
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }
    @PutMapping(value = "/auth/changeUserType")
    public UserDTO changeUserType(@Valid @RequestBody UserDTO userDTO){
        return userService.changeUserType(userDTO);
    }
    @PutMapping(value = "/deleteUser/{id}")
    public UserDTO deleteUser(@PathVariable int id){
        return userService.deleteUserById(id);
    }

}

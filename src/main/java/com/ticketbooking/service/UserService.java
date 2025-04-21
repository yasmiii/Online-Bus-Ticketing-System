package com.ticketbooking.service;

import com.ticketbooking.dto.UserDTO;
import com.ticketbooking.entity.User;
import com.ticketbooking.execption.EntityAlreadyExistException;
import com.ticketbooking.execption.EntityNotFoundException;
import com.ticketbooking.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    public UserDTO login(UserDTO userDTO){
        User user = getUserByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        return modelMapper.map(user, UserDTO.class);
    }
    public UserDTO addUser(UserDTO userDTO){
        findExistingUser(userDTO.getEmail(), userDTO.getNic(), userDTO.getMobile());
        userDTO.setStatus("Active");
        userDTO.setType("Passenger");
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public List<UserDTO> viewUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }
    public UserDTO viewUser(int id) {
        User user = getUser(id);
        return modelMapper.map(user, UserDTO.class);
    }
    public UserDTO updateUser(UserDTO userDTO) throws EntityNotFoundException {
        User existingUser = getUser((int) userDTO.getId());
        userDTO.setStatus(existingUser.getStatus());
        userDTO.setType(existingUser.getType());
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }
    public UserDTO changeUserType(UserDTO userDTO){
        User existingUser = getUser((int) userDTO.getId());
        existingUser.setType(userDTO.getType());
        userRepo.save(existingUser);
        return modelMapper.map(existingUser, UserDTO.class);
    }
    public UserDTO deleteUserById(int id){
        User user = getUser(id);
        user.setStatus("Deactivate");
        userRepo.save(user);
        return modelMapper.map(user, UserDTO.class);

    }
    private void findExistingUser(String email, String nic, String mobile) {
        Optional<User> existingUser = userRepo.findByEmailOrNicOrMobile(email, nic, mobile);
        if (existingUser.isPresent()) {
            throw new EntityAlreadyExistException("USER WITH THE PROVIDED DETAILS ALREADY EXISTS");
        }
    }
    private User getUser(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty())
            throw new EntityNotFoundException("USER NOT FOUND WITH ID : "+ id);
        return user.get();
    }
    private User getUserByEmailAndPassword(String email, String password){
        Optional<User> user = userRepo.findByEmailAndPassword(email, password);
        if (user.isEmpty())
            throw new EntityNotFoundException("USER NOT FOUND WITH EMAIL AND PASSWORD");
        return user.get();
    }
}

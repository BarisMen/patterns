package com.design.ntierpattern.service.Impl;

import com.design.ntierpattern.advice.UserNotFound;
import com.design.ntierpattern.dto.UserDTO;
import com.design.ntierpattern.entity.User;
import com.design.ntierpattern.repository.IUserRepository;
import com.design.ntierpattern.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = modelMapper.map(userDTO,User.class);
        user.setCreatedBy("Admin");
        user.setCreatedDate(new Date());
        return modelMapper.map(iUserRepository.save(user),UserDTO.class);
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = iUserRepository.findAll();
        List<UserDTO> dtos = users.stream().map(user -> modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public UserDTO getUser(Long id) throws Exception {
        Optional<User> userResult = iUserRepository.findById(id);

        if (userResult.isPresent()) {
            return modelMapper.map(userResult,UserDTO.class);
        }
        throw new UserNotFound("Can not found any record");
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) throws Exception {
        Optional<User> userResult = iUserRepository.findById(id);

        if (userResult.isPresent()) {
            userResult.get().setName(userDTO.getName());
            userResult.get().setSurname(userDTO.getSurname());
            userResult.get().setUpdatedBy("Admin");
            userResult.get().setUpdateAt(new Date());
            return modelMapper.map(iUserRepository.save(userResult.get()),UserDTO.class);

        }
        throw new Exception("Can't save entity");
    }

    @Override
    public Boolean deleteUser(long id) {

        Optional<User> userResult = iUserRepository.findById(id);
        if (userResult.isPresent()) {
            iUserRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

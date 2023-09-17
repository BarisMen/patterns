package com.design.ntierpattern.service;

import com.design.ntierpattern.dto.UserDTO;
import com.design.ntierpattern.entity.User;

import java.util.List;

public interface IUserService {

    UserDTO createUser (UserDTO users);

    List<UserDTO> getUsers();

    UserDTO getUser (Long id) throws Exception;

    UserDTO updateUser (long id,UserDTO userDTO) throws Exception;

    Boolean deleteUser (long id);
}

package com.design.ntierpattern.api;

import com.design.ntierpattern.dto.UserDTO;
import com.design.ntierpattern.entity.User;
import com.design.ntierpattern.service.IUserService;
import com.design.ntierpattern.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
//@RequiredArgsConstructor // lombok ilede user servis referansını burada ki property e enjekte edebiliriz
public class UserController {


    //@Autowired ilede user servis referansını burada ki property e enjekte edebiliriz
    private final IUserService iUserService;

    //constructor kullanarak da  user servis referansını burada ki property e enjekte edebiliriz
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO resultUser = iUserService.createUser(userDTO);
        return ResponseEntity.ok(resultUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> resultusers = iUserService.getUsers();

        return ResponseEntity.ok(resultusers);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) throws Exception {
        UserDTO resutUser = null;
        try {
            resutUser = iUserService.getUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(resutUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable long id, @RequestBody UserDTO userDTO) throws Exception {
        UserDTO resultUser = null;
        try {
            resultUser = iUserService.updateUser(id, userDTO);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(resultUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {

        Boolean processResult = iUserService.deleteUser(id);
        return ResponseEntity.ok(processResult);
    }


}

package com.design.ntierpattern.repository;

import com.design.ntierpattern.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User,Long> {
   /* Users findByName(String name);
    Users findByNameAndSurname(String name ,String surname);
    @Query("")
    Users getUser(String user);*/
}

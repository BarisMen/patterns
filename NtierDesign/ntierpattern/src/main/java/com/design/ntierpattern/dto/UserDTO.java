package com.design.ntierpattern.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDTO {

    private String name;
    private String surname;
}

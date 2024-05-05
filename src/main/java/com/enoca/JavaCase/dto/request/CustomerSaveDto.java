package com.enoca.JavaCase.dto.request;

import com.enoca.JavaCase.utility.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerSaveDto {
    String name;

    String surname;

    String email;

    Date birthDate;

    String phone;

    @Enumerated(EnumType.STRING)
    Gender gender;

}

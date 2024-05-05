package com.enoca.JavaCase.service;

import com.enoca.JavaCase.dto.request.CustomerSaveDto;
import com.enoca.JavaCase.repository.CustomerRepository;
import com.enoca.JavaCase.repository.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer addCustomer(CustomerSaveDto dto) {
        Customer customer = Customer.builder()
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .gender(dto.getGender())
                .birthDate(dto.getBirthDate())
                .name(dto.getName())
                .surname(dto.getSurname())
                .build();
        return customerRepository.save(customer);
    }
}


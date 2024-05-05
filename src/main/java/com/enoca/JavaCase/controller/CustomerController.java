package com.enoca.JavaCase.controller;

import com.enoca.JavaCase.dto.request.CustomerSaveDto;
import com.enoca.JavaCase.repository.entity.Customer;
import com.enoca.JavaCase.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid CustomerSaveDto dto){
        Customer customer =   customerService.addCustomer(dto);
        return ResponseEntity.ok().build();
    }

}

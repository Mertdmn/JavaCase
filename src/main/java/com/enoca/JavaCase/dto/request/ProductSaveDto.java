package com.enoca.JavaCase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSaveDto {
    String name;

    String barcode;

    String brand;

    String model;

    Double price;
}

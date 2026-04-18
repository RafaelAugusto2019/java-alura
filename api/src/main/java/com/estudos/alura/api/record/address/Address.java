package com.estudos.alura.api.address;

public record Address(
        String addressLine1,
        String addressLine2,
        String District,
        String zipCode,
        String city,
        String state) {

}

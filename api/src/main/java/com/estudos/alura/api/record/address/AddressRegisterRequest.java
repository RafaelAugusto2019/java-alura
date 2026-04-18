package com.estudos.alura.api.record.address;

public record AddressRegisterRequest(
        String addressLine1,
        String addressLine2,
        String district,
        String zipCode,
        String city,
        String state) {

}

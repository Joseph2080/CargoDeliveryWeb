package com.example.cargodeliveryweb.Model.Cargo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    void calculateDelivery() {
        assertEquals(23650,Cargo.calculateDelivery("container",260,900,"Ukraine"));
    }
}
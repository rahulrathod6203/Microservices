package com.cg.controller;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;
import com.cg.service.AddressService;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{customerId}")
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long customerId, @RequestBody AddressRequest addressRequest) {
        AddressResponse address = addressService.createAddress(customerId, addressRequest);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(address.id())
                    .toUri();

        return ResponseEntity.created(location).body(address);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress() {
        List<AddressResponse> allAddress = addressService.getAllAddress();
        return ResponseEntity.ok(allAddress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id) {
        AddressResponse studentById = addressService.getAddressById(id);
        log.info("GET request called...");
        return ResponseEntity.ok(studentById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long id, @RequestBody AddressRequest addressRequest) {
        AddressResponse addressResponse = addressService.updateAddress(id, addressRequest);
        return ResponseEntity.accepted().body(addressResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress( @PathVariable Long id) {
        return addressService.deleteAddress(id);
    }


}

package com.cg.controller;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;
import com.cg.service.AddressService;
import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{studentId}")
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long studentId, @RequestBody AddressRequest addressRequest) {
        AddressResponse address = addressService.createAddress(studentId, addressRequest);

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

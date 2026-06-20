package com.cg.feignClients;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ADDRESS-SERVICE", path = "/api/v1/address")
public interface AddressClient {

    @PostMapping("/{studentId}")
    public ResponseEntity<AddressResponse> createAddress(@PathVariable Long studentId, @RequestBody AddressRequest addressRequest);

    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllAddress();

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id);

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long id,
                                                         @RequestBody AddressRequest addressRequest);

    @DeleteMapping("/{id}")
    public String deleteAddress( @PathVariable Long id);

}

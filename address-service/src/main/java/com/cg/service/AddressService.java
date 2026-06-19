package com.cg.service;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;

import java.util.List;

public interface AddressService {

    AddressResponse createAddress(AddressRequest addressRequest);

    List<AddressResponse> getAllAddress();

    AddressResponse getAddressById(Long id);

    AddressResponse updateAddress(Long id, AddressRequest addressRequest);

    String deleteAddress(Long id);
}

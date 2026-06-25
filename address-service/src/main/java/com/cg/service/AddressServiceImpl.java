package com.cg.service;

import com.cg.dto.AddressRequest;
import com.cg.dto.AddressResponse;
import com.cg.exception.AddressNotFoundException;
import com.cg.mapper.AddressMapper;
import com.cg.model.Address;
import com.cg.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressMapper mapper;

    @Override
    public AddressResponse createAddress(Long customerId, AddressRequest addressRequest) {

        Address address = mapper.toEntity(addressRequest);
        address.setCustomerId(customerId);
        Address savedAddress = addressRepository.save(address);

        return mapper.toResponse(savedAddress);
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public AddressResponse getAddressById(Long id) {
        return addressRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id="+id));
    }

    @Override
    public AddressResponse updateAddress(Long id, AddressRequest addressRequest) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id=" + id));

        address.setStreet(addressRequest.street());
        address.setCity(addressRequest.city());
        address.setPinCode(addressRequest.pinCode());
        address.setState(addressRequest.state());

        Address updatedAddress = addressRepository.save(address);

        return mapper.toResponse(updatedAddress);
    }

    @Override
    public String deleteAddress(Long id) {
        addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found with id="+id));

        addressRepository.deleteById(id);
        return "Address with id="+id + " deleted successfully!";
    }
}

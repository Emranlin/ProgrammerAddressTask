package peaksoft.service;

import peaksoft.entity.Address;
import peaksoft.enums.Countries;

import java.util.List;

public interface AddressService {
    String save(Address address,Long countryId);
    String saveAll(List<Address>addresses,Long countryId);

    List<Address>getAll();
    Address findById(Long id);
    String deleteById(Long id);
    String deleteAll();
    Address update(Address address,Long id);


}

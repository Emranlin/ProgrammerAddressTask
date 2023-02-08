package peaksoft.repository;

import peaksoft.entity.Address;

import java.util.List;

public interface AddressRepository {
    void save(Address address,Long countryId);
    void saveAll(List<Address>addresses,Long countryId);
    List<Address>getAll();
    Address findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    Address update(Address address,Long id);



}

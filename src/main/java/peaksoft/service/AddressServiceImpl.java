package peaksoft.service;

import peaksoft.entity.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.AddressRepositoryImpl;

import java.util.List;

public class AddressServiceImpl implements AddressService{
    AddressRepository addressRepository=new AddressRepositoryImpl();
    @Override
    public String save(Address address,Long countryId) {
        addressRepository.save(address,countryId);
        return "Success saved";
    }

    @Override
    public String saveAll(List<Address> addresses,Long countryId) {
        addressRepository.saveAll(addresses,countryId);
        return "success saved";
    }



    @Override
    public List<Address> getAll() {

        return  addressRepository.getAll();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        addressRepository.deleteById(id);
        return "Successful deleted";
    }

    @Override
    public String deleteAll() {
        addressRepository.deleteAll();
        return "Success deleted";
    }

    @Override
    public Address update(Address address, Long id) {
        return addressRepository.update(address, id);
    }
}

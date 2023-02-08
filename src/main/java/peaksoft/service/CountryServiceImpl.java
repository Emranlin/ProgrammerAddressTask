package peaksoft.service;

import peaksoft.entity.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.CountryRepositoryImpl;

import java.util.List;

public class CountryServiceImpl implements CountryService{
    CountryRepository countryRepository=new CountryRepositoryImpl();
    @Override
    public String saveCountry(Country country) {
        countryRepository.saveCountry(country);
        return "successful saved";
    }

    @Override
    public String saveAllCountries(List<Country> countries) {
        countryRepository.saveAllCountries(countries);
        return "Success saved";
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.getAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        countryRepository.deleteById(id);
        return "successful deleted";
    }

    @Override
    public String deleteAll() {
        countryRepository.deleteAll();
        return "Successful deleted";
    }

    @Override
    public Country update(Country country, Long id) {
        return countryRepository.update(country,id);
    }

    @Override
    public Country getLongDescription() {
        return countryRepository.getLongDescription();
    }

    @Override
    public Country findByName(String countryName) {
        return countryRepository.findByName(countryName);
    }

    @Override
    public String countTheCountry() {
        countryRepository.countTheCountry();
        return "successful counted";
    }
}

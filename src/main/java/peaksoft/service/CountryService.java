package peaksoft.service;

import peaksoft.entity.Country;

import java.util.List;

public interface CountryService {
    String saveCountry(Country country);
    String saveAllCountries(List<Country> countries);
    List<Country> getAll();
    Country findById(Long id);
    String deleteById(Long id);
    String deleteAll();
    Country update(Country country ,Long id);
    Country getLongDescription();
    Country findByName(String countryName);
    String countTheCountry();
}

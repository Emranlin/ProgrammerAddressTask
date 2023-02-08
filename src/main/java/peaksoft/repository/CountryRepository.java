package peaksoft.repository;

import peaksoft.entity.Country;

import java.util.List;

public interface CountryRepository {
    void saveCountry(Country country);
    void saveAllCountries(List<Country> countries);
    List<Country> getAll();
    Country findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    Country update(Country country ,Long id);
    Country getLongDescription();
    Country findByName(String name);
    int CountProgrammerInSameCountry(String countryName);



}

package peaksoft.service;

import peaksoft.entity.Programmer;

import java.util.List;

public interface ProgrammerService {
    String addConstraintUnique();
    String save(Programmer programmer);
    String saveAll(List<Programmer> programmers);
    List<Programmer>getAll();
    Programmer findById(Long id);
    Programmer deleteById(Long id);
    String deleteAll();
    Programmer update(Programmer programmer,Long id);
    Programmer findByCountryName(String countryName);
    Programmer findYoungest();
    Programmer findEldest();

}

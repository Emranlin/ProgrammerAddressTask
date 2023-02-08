package peaksoft.repository;

import peaksoft.entity.Programmer;

import java.util.List;

public interface ProgrammerRepository {
    void addConstraintUnique();
    void save(Programmer programmer);
    void saveAll(List<Programmer>programmers);
    List<Programmer>getAll();
    Programmer findById(Long id);
    Programmer deleteById(Long id);
    void deleteAll();
    Programmer update(Programmer programmer,Long id);
    Programmer findByCountryName(String countryName);
    int findYoungest();
    int  findEldest();



}

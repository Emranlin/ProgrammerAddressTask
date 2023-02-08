package peaksoft.service;

import peaksoft.entity.Programmer;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.ProgrammerRepositoryImpl;

import java.util.List;

public class ProgrammerServiceImpl implements ProgrammerService{
    ProgrammerRepository programmerRepository=new ProgrammerRepositoryImpl();
    @Override
    public String addConstraintUnique() {
        programmerRepository.addConstraintUnique();
        return null;
    }

    @Override
    public String save(Programmer programmer) {
        programmerRepository.save(programmer);
        return "succesfull saved";
    }

    @Override
    public String saveAll(List<Programmer> programmers) {
        programmerRepository.saveAll(programmers);
        return "succesfull saved";
    }

    @Override
    public List<Programmer> getAll() {

        return programmerRepository.getAll();
    }

    @Override
    public Programmer findById(Long id) {
        return programmerRepository.findById(id);
    }

    @Override
    public Programmer deleteById(Long id) {
        return programmerRepository.deleteById(id);
    }

    @Override
    public String deleteAll() {
        programmerRepository.deleteAll();
        return "success";
    }

    @Override
    public Programmer update(Programmer programmer, Long id) {

        return programmerRepository.update(programmer,id);
    }

    @Override
    public Programmer findByCountryName(String countryName) {
        return programmerRepository.findByCountryName(countryName);
    }

    @Override
    public Programmer findYoungest() {
        return programmerRepository.findYoungest();
    }

    @Override
    public Programmer findEldest() {
        return programmerRepository.findEldest();
    }
}

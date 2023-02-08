package peaksoft.service;

import peaksoft.entity.Project;

import java.util.List;

public interface ProjectService {
    String save(Project project);
    String saveAll(List<Project> projects);
    Project findById(Long id);
    String deleteById(Long id);
    String deleteAll();
    Project update(Project project,Long id);
    String assign(Long id,Long programmerId);
    String findExpensive();
    void findShortTimeProject();
}

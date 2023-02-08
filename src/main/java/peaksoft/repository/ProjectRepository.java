package peaksoft.repository;

import peaksoft.entity.Project;

import java.util.List;

public interface ProjectRepository {
    void save(Project project);
    void saveAll(List<Project> projects);
    Project findById(Long id);
    void deleteById(Long id);
    void deleteAll();
    Project update(Project project,Long id);
    void assign(Long id,Long programmerId);
    void findExpensive();
    void findShortTimeProject();

}

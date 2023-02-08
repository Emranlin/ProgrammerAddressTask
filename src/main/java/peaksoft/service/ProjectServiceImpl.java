package peaksoft.service;

import peaksoft.entity.Programmer;
import peaksoft.entity.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.ProjectRepositoryImpl;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository = new ProjectRepositoryImpl();


    @Override
    public String save(Project project) {
        projectRepository.save(project);
        return "Successfully...";
    }

    @Override
    public String saveAll(List<Project> projects) {
        projectRepository.saveAll(projects);
        return "Successfully...";
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        projectRepository.deleteById(id);
        return "Successfully...";
    }

    @Override
    public String deleteAll() {
        projectRepository.deleteAll();
        return "Successfully...";
    }

    @Override
    public Project update(Project project, Long id) {
        return projectRepository.update(project,id);
    }

    @Override
    public String assign(Long id, Long programmerId) {
        projectRepository.assign(id,programmerId);
        return "Successfully...";
    }

    @Override
    public String findExpensive() {
         projectRepository.findExpensive();
        return "Successfully...";
    }

    @Override
    public void findShortTimeProject() {
         projectRepository.findShortTimeProject();
    }
}
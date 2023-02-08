package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.entity.Programmer;
import peaksoft.entity.Project;

import java.time.Period;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository{
    private EntityManagerFactory entityManagerFactory;
    public ProjectRepositoryImpl(){
        this.entityManagerFactory= DataBaseConnection.getEntityManagerFactory();
        
    }
    @Override
    public void save(Project project) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAll(List<Project> projects) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Project project : projects) {
            entityManager.persist(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Project findById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project result = entityManager.createQuery("select p from Project p", Project.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project result = entityManager.createQuery("select p from Project p ", Project.class).setParameter("id", id).getSingleResult();
       entityManager.remove(result);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table project cascade", Project.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Project update(Project project, Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project result = entityManager.createQuery("select p from Project p where id=:id", Project.class).setParameter("id", id).getSingleResult();
        result.setProjectName(project.getProjectName());
        result.setDescription(project.getDescription());
        result.setDateOfStart(project.getDateOfStart());
        result.setDateOfFinish(project.getDateOfFinish());
        result.setPrice(project.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }

    @Override
    public void assign(Long id, Long programmerId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        project.getProgrammers().add(entityManager.find(Programmer.class,programmerId));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void findExpensive() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int i = entityManager.createNativeQuery("select * from projects order by price desc limit 1", Project.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(i);



    }

    @Override
    public void findShortTimeProject() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project project = (Project)entityManager.createNativeQuery("select *,p.getDateOfFinish-p.getDateOfStart as year from projects p order by year limit 1 ", Project.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(project.getProjectName()+","+ Period.between(project.getDateOfStart(),project.getDateOfFinish()));
    }
}

package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.entity.Programmer;

import java.util.List;

public class ProgrammerRepositoryImpl implements ProgrammerRepository{
    private EntityManagerFactory entityManagerFactory;
    public ProgrammerRepositoryImpl(){
        this.entityManagerFactory= DataBaseConnection.getEntityManagerFactory();
    }
    @Override
    public void addConstraintUnique() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("alter table Programmer add constraint email unique (email)", Programmer.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(Programmer programmer) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(programmer);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveAll(List<Programmer> programmers) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(programmers);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Programmer> getAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Programmer> resultList = entityManager.createQuery("select p from Programmer p", Programmer.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public Programmer findById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select p from Programmer p", Programmer.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public Programmer deleteById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select p from Programmer p", Programmer.class)
                .setParameter("id", id).getSingleResult();
        entityManager.remove(singleResult);
        entityManager.getTransaction().commit();
        entityManager.close();

        return singleResult;
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table programmers cascade", Programmer.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Programmer update(Programmer programmer, Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer result = entityManager.createQuery("select p from Programmer p where id=:id", Programmer.class)
                .setParameter("id", id).getSingleResult();
        result.setFullName(programmer.getFullName());
        result.setEmail(programmer.getEmail());
        result.setDateOfBirth(programmer.getDateOfBirth());
        result.setStatus(programmer.getStatus());
        entityManager.getTransaction().commit();
        entityManager.close();

        return null;
    }

    @Override
    public Programmer findByCountryName(String countryName) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Programmer singleResult = entityManager.createQuery("select p from Programmer p join Address a on p.id=a.id ", Programmer.class)
                .setParameter("countries", countryName).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public int findYoungest() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int i = entityManager.createNativeQuery("select * from programmers order by date_of_birth  limit 1", Programmer.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(i);
        return i;
    }

    @Override
    public int findEldest() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int i = entityManager.createNativeQuery("select * from programmers order by date_of_birth desc limit 1", Programmer.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(i);
        return i;
    }
}

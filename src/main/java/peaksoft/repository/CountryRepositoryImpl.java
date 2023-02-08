package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.entity.Country;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository {
    private EntityManagerFactory entityManagerFactory;

    public CountryRepositoryImpl() {
        this.entityManagerFactory = DataBaseConnection.getEntityManagerFactory();
    }

    @Override
    public void saveCountry(Country country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void saveAllCountries(List<Country> countries) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Country country : countries) {
            entityManager.persist(country);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Country> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> resultList = entityManager.createQuery("select c from Country c ", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public Country findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country result = entityManager.createQuery("select c from Country c where id=:id", Country.class)
                .setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        return result;
    }


    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country result = entityManager.createQuery("select c from Country c where  id=:id", Country.class)
                .setParameter("id", id).getSingleResult();
        entityManager.remove(result);
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public void deleteAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table country cascade", Country.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public Country update(Country country, Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country result = entityManager.createQuery("select c from Country c where id=:id", Country.class)
                .setParameter("id", id).getSingleResult();
        result.setCountries(country.getCountries());
        result.setDescription(country.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();


        return result;
    }

    @Override
    public Country getLongDescription() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int result = entityManager.createNativeQuery("select * from countries order by length(description) desc limit 1", Country.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(result);

        return null;
    }

    @Override
    public Country findByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country result = entityManager.createQuery("select c from Country c ", Country.class)
                .setParameter("name", name).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public int CountProgrammerInSameCountry(String countryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Country> resultList = entityManager.createQuery("select c from Country c where country=:countryName", Country.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList.size();

    }
}

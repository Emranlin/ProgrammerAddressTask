package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConnection;
import peaksoft.entity.Address;
import peaksoft.entity.Country;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository{
    private EntityManagerFactory entityManagerFactory;
    public AddressRepositoryImpl(){
        this.entityManagerFactory= DataBaseConnection.getEntityManagerFactory();

    }
    @Override
    public void save(Address address,Long countryId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country country = entityManager.find(Country.class, countryId);
        address.setCountry(country);
        entityManager.merge(country);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void saveAll(List<Address> addresses,Long countryId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Address address : addresses) {
            Country country = entityManager.find(Country.class, countryId);
            address.setCountry(country);
            entityManager.merge(country);
          entityManager.persist(address);
        }
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Address> getAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Address> addressList = entityManager.createQuery("SELECT a from Address a", Address.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return addressList;
    }

    @Override
    public Address findById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address result = entityManager.createQuery("SELECT a from Address a", Address.class)
                .setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address result = entityManager.createQuery("SELECT a from Address a", Address.class)
                .setParameter("id", id).getSingleResult();
        entityManager.detach(result);
        entityManager.remove(result);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table addresses cascade", Address.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Address update(Address address, Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address address1 = entityManager.find(Address.class, id);
        address1.setRegionName(address.getRegionName());
        address1.setStreet(address.getStreet());
        address1.setHomeNumber(address.getHomeNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
        return address1;
    }
}

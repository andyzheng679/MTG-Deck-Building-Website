package com.azSeniorProject.springboot.seniorProject.dao;

import com.azSeniorProject.springboot.seniorProject.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl implements UserDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(User theUser) {
        entityManager.persist(theUser);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve user
        User theUser = entityManager.find(User.class, id);

        // delete user
        entityManager.remove(theUser);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int numRowsDeleted = entityManager.createQuery("DELETE FROM User").executeUpdate();
        return numRowsDeleted;
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        // Create a TypedQuery using JPA to fetch the user with the given email from the database
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
        query.setParameter("email", email);

        try {
            // Attempt to get a single result from the query
            return query.getSingleResult();
        } catch (NoResultException e) {
            // If no result is found, return null
            return null;
        }
    }
}

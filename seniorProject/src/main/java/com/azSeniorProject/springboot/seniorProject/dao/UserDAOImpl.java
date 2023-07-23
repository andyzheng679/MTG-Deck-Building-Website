package com.azSeniorProject.springboot.seniorProject.dao;

import com.azSeniorProject.springboot.seniorProject.entity.User;
import jakarta.persistence.EntityManager;
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
}

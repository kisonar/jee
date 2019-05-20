/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jpa.lib.accsessor.user;

import com.mossad.jpa.lib.accsessor.AbstractAccessor;
import com.mossad.jpa.lib.domain.user.User;
import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.jpa.lib.irp.IServiceUser;
import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author mmigdal
 */
public class UserAccessor extends AbstractAccessor implements IServiceUser {

    private final UserFactory userFactory;


    public UserAccessor(EntityManager em) {
        super(em);
        userFactory = new UserFactory();
    }

    @Override
    public User createUser(String email, String password, String name, String surname) throws UserExistsException {

        User user = userFactory.createUser(name, surname, password, email);
        em.persist(user);
        return user;
    }

    @Override
    public User loginUser(String email, String password) throws UserNotFoundException {

        // List<User> usersResult = em
        List<User> usersResult = new ArrayList<>();
        usersResult.addAll(em
            .createNamedQuery(Constants.LOGIN_USER_BY_EMAIL_AND_PASSWORD)
            .setParameter(Constants.PARAM_EMAIL, email)
            .setParameter(Constants.PARAM_PASSWORD, password)
            .getResultList());
        //getSingleResult() maybe?

        if (usersResult.isEmpty()) {
            throw new UserNotFoundException(email, password);
        }
        return usersResult.get(0);

    }

    @Override
    public User getById(Long id) throws UserNotFoundException {

        return (User) em.createNamedQuery(Constants.QUERY_GET_USER_BY_ID)
            .setParameter(Constants.PARAM_ID, id).getSingleResult();

    }

    @Override
    public User getByEmail(String email) throws UserNotFoundException {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();
        Root<User> root = cq.from(User.class);
        cq.where(
            cb.equal(
                root.get("email"),
                cb.parameter(String.class, "email")));

        TypedQuery<User> query = em.createQuery(cq);
        query.setParameter("email", email);
        User user = query.getSingleResult();

        //OLD approach
        //List<User> usersResult = new ArrayList<>();
        //usersResult.addAll(em
        //		.createNamedQuery(Constants.QUERY_GET_USER_BY_EMAIL)
        //		.setParameter(Constants.PARAM_EMAIL, email).getResultList());
        //    
        //if (usersResult.isEmpty()) {
        //	throw new UserNotFoundException(email);
        //} else {
        //	return usersResult.get(0);
        //}
        return user;
    }

    @Override
    public User updateUser(String newName, String newSurname, User user) throws UserNotFoundException {
        throw new UnsupportedOperationException(
            "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activateUser(Long id) {
        throw new UnsupportedOperationException(
            "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeUser(User user) throws UserNotFoundException {
        em.remove(user);
    }

    @Override
    public List<User> getUsers() {
        
          /*
         CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
        
         Root<User> pet = cq.from(User.class);
         cq.select(pet);

         TypedQuery<User> q = em.createQuery(cq);
         List<User> users = q.getResultList();
            
         return users;
         */

        
        /*
        List<User> usersResult = new ArrayList<>();

        usersResult.addAll(em
                .createNamedQuery(Constants.GET_ALL_USERS)
                .getResultList());

        return usersResult;
                
                
                */

        List<User> usersResult = new ArrayList<>();

        usersResult.addAll(em
            .createNamedQuery(Constants.GET_ALL_USERS)
            .getResultList());

        return usersResult;

    }

}

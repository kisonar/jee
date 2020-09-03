/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.services.user;

import com.mossad.irp.interfaces.user.IServiceUserLocal;
import com.mossad.irp.interfaces.user.IServiceUserRemote;
import com.mossad.jpa.lib.accsessor.user.UserAccessor;
import com.mossad.jpa.lib.domain.user.User;
import com.mossad.jpa.lib.factories.UserFactory;
import com.mossad.lib.domain.constants.Constants;
import com.mossad.lib.domain.exceptions.user.UserExistsException;
import com.mossad.lib.domain.exceptions.user.UserNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author mmigdal
 */
@Stateless
// (name=Constants.BINDING_SERVICE_USER,mappedName=Constants.BINDING_SERVICE_USER)
@Remote(IServiceUserRemote.class)
@Local(IServiceUserLocal.class)
public class ServiceUser implements IServiceUserLocal, IServiceUserRemote {

    private static final Logger log = Logger.getLogger(Constants.LOGGER_SERVICE_USER);
    private UserFactory userFactory;
    private UserAccessor userAccessor;
    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void init() {
        userAccessor = new UserAccessor(em);
        userFactory = new UserFactory();
    }

    @PreDestroy
    public void destroy() {
        userFactory = null;
        userAccessor = null;
    }

    @Override
    public User loginUser(String email, String password)
        throws UserNotFoundException {

        return userAccessor.loginUser(email, password);
    }

    @Override
    public User getById(Long id) throws UserNotFoundException {

        log.log(Level.INFO, "ServiceUser - finding user :{0}", id);
        return userAccessor.getById(id);
    }

    @Override
    public User getByEmail(String email) throws UserNotFoundException {

        return userAccessor.getByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return userAccessor.getUsers();
    }

    @Override
    public User createUser(String email, String password, String name,
        String surname) throws UserExistsException {
        return userAccessor.createUser(email, password, name, surname);
    }

    @Override
    public User updateUser(String newName, String newSurname, User user)
        throws UserNotFoundException {
        return userAccessor.updateUser(newName, newSurname, user);
    }

    @Override
    public void activateUser(Long id) {
        userAccessor.activateUser(id);
    }

    @Override
    public void removeUser(User user) throws UserNotFoundException {
        userAccessor.removeUser(user);
    }
}

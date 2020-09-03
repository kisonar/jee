/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.jap.lib.factories;

import com.mossad.jpa.lib.domain.user.User;
import com.mossad.jpa.lib.factories.UserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mmigdal
 */
public class UserFactoryTest {

    private UserFactory userFactory;

    @BeforeEach
    public void setUp() {
        userFactory = new UserFactory();
    }

    @AfterEach
    public void tearDown() {
        userFactory = null;
    }

    @Test
    public void dummyTest() {

        Assertions.assertNotNull(userFactory);

    }

    @Test
    public void testUserCtreation() {
        String name = "myName";
        String surname = "";
        String password = "";
        String email = "";
        User user = userFactory.createUser(name, surname, password, email);
    }
}

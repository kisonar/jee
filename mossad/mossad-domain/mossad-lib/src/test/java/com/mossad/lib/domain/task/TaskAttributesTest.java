package com.mossad.lib.domain.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TaskAttributesTest {

    private TaskAttributes taskAttributes ;//= new TaskAttributes();
    private final String description = "test description";
    private final long priority = 0;
    private final long status = 2;
    private final String title = "TAsk title";
    private final long type = 1;
    private final long user = 123456789;

    
    @BeforeEach
    void setUp() {
        taskAttributes = new TaskAttributes();
    }

    
    @AfterEach
    public void tearDown() {
        taskAttributes = null;
    }
    
    @Test
    void check(){}
    

    @Test
    public void testTaskAttributes() {

        Assertions.assertNotNull(taskAttributes);

        taskAttributes.setDescription(description);
        taskAttributes.setPriority(priority);
        taskAttributes.setStatus(status);
        taskAttributes.setTitle(title);
        taskAttributes.setType(type);
        taskAttributes.setUser(user);

        String myDescription = taskAttributes.getDescription();
        Assertions.assertEquals(myDescription, description);

        long myPriority = taskAttributes.getPriority();
        Assertions.assertEquals(myPriority, priority);

        long myStatus = taskAttributes.getStatus();
        Assertions.assertEquals(myStatus, status);

        String myTitle = taskAttributes.getTitle();
        Assertions.assertEquals(myTitle, title);

        long myType = taskAttributes.getType();
        Assertions.assertEquals(myType, type);

        long myUser = taskAttributes.getUser();
        Assertions.assertEquals(myUser, user);

    }
}

package com.mossad.ocjp.eight.designpatterns.builder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.mossad.ocjp.eight.designpatterns.builder.Entity.Builder;

/**
 *
 * @author mmigdal
 */
public class EntityTest {

    @Test
    public void test() {
        Builder builder = Builder.get();
        Entity entity = builder.withId(5).withName("myName").build();
        Assertions.assertNotNull(entity);
    }

}

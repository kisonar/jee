package com.mossad.lib.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mmigdal
 */
public class TestTimeMeasurement {

    private TimeMeasurement timeMeasurement;

    @BeforeEach
    void beforeEach() {
        timeMeasurement = new TimeMeasurement();
    }

    @AfterEach
    public void tearDown() {
        timeMeasurement = null;
    }

    @Test
    public void testReset() {
        timeMeasurement.reset();
        Assertions.assertEquals(0, timeMeasurement.getResultInMiliseconds());
    }

    @Test
    public void testDefaultBehaviour() {
        timeMeasurement.reset();
        Assertions.assertEquals(0, timeMeasurement.getResultInMiliseconds());

        timeMeasurement.start();
        for (int x = 0; x < 1000000000; x++) {
        }
        timeMeasurement.stop();

        Assertions.assertTrue(checkValue());
    }

    private boolean checkValue() {
        return timeMeasurement.getResultInMiliseconds() > 0 ? true : false;
    }
}

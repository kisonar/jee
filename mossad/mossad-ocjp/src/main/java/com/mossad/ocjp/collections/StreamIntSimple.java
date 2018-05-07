package com.mossad.ocjp.collections;

import com.mossad.lib.util.TimeMeasurement;

import java.util.stream.IntStream;

/**
 * Created by mmigdal on 2017-08-29.
 */
public class StreamIntSimple {


    public static void main(String[] args) {

        int intMaxValue = 1200000;
        TimeMeasurement tm = new TimeMeasurement();
        tm.start();
        IntStream one = IntStream.range(3, 1200000);
        one.filter(item -> item % 2 == 0);
        tm.stop();
        tm.printResult();

        tm.reset();

        tm.start();
        IntStream two =  IntStream.range(3, 20000);
        two.parallel().filter(item -> item % 2 == 0);
        tm.stop();
        tm.printResult();



    }

}

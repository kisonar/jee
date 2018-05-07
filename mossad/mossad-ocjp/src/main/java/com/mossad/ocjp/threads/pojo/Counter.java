package com.mossad.ocjp.threads.pojo;

/**
 * Created by mmigdal on 2017-08-29.
 */
public class Counter {

    int count = 0;
    public Counter() {

    }

    public void increment() {
        count = count + 1;
    }

    public synchronized  void incrementSync() {
        count = count + 1;
    }


    public int getResult(){return count;}

}

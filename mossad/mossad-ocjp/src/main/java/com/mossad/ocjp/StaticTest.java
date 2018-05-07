package com.mossad.ocjp;


class Super {

    static String ID = "QBANK";
}

class Sub extends Super {

    static {
        System.out.print("In Sub");
    }
}

public class StaticTest {

    public static void main(String[] args) {
        System.out.println(Sub.ID);
    }
}

package com.mincat.test.factory.simplefactory;

/**
 * @author Mings
 */

public class SimpleFactory {

    public static Coding codingLanguage(String codingName) throws Exception {

        if (codingName.equals("Java")) {
            return new CodingJava();
        } else if (codingName.equals("C")) {
            return new CodingC();
        } else if (codingName.equals("Oc")) {
            return new CodingOc();
        } else {
            throw new Exception("没有该产品");
        }
    }


}

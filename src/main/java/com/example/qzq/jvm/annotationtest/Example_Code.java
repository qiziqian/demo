package com.example.qzq.jvm.annotationtest;

/**
 * @Description
 * @Date 2020/2/21 12:59
 * @Author by qiziqian
 */
// javac  -encoding "utf-8"   com/example/qzq/jvm/annotationtest/NameChecker.java
//javac  -encoding "utf-8"   com/example/qzq/jvm/annotationtest/NameCheckProcessor.java
//javac  -encoding "utf-8" -processor com.example.qzq.jvm.annotationtest.NameCheckProcessor   com\example\qzq\jvm\annotationtest\Example_Code.java
public class Example_Code {
    static final int _FORTY_TWO = 42;
    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAME_CODE() {
        return;
    }

    public void NoTcamelCASEmethodNAME() {
        return;
    }

    enum colors {
        red, blue, green;
    }

}

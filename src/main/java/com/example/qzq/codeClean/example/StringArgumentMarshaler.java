package com.example.qzq.codeClean.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.example.qzq.codeClean.example.ErrorCode.MISSING_STRING;

/**
 * @Classname StringArgumentMarshaler
 * @Description
 * @Date 2020/1/7 14:32
 * @Created by qiziqian
 */
public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";

    public static String getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArgumentMarshaler) return ((StringArgumentMarshaler) am).stringValue;
        else return "";
    }


    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }
}

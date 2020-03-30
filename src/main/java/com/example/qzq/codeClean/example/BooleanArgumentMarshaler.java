package com.example.qzq.codeClean.example;

import java.util.Iterator;

/**
 * @Classname BooleanArgumentMarshaler
 * @Description
 * @Date 2020/1/7 14:20
 * @Created by qiziqian
 */
public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;

    public static boolean getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof BooleanArgumentMarshaler) return ((BooleanArgumentMarshaler) am).booleanValue;
        else return false;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }
}

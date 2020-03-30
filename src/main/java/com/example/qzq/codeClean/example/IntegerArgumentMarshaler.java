package com.example.qzq.codeClean.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.example.qzq.codeClean.example.ErrorCode.*;

/**
 * @Classname IntegerArgumentMarshaler
 * @Description
 * @Date 2020/1/7 14:34
 * @Created by qiziqian
 */
public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue = 0;

    public static int getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof IntegerArgumentMarshaler) return ((IntegerArgumentMarshaler) am).intValue;
        else return 0;
    }

    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }
}

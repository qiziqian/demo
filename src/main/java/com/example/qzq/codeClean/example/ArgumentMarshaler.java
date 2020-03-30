package com.example.qzq.codeClean.example;

import com.example.qzq.codeClean.example.ArgsException;

import java.util.Iterator;

/**
 * @Classname ArgumentMarshaler
 * @Description
 * @Date 2020/1/7 14:18
 * @Created by qiziqian
 */
public interface ArgumentMarshaler {
    void set(Iterator<String> currentArgument) throws ArgsException;
}

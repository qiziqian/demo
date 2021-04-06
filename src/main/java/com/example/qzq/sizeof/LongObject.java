package com.example.qzq.sizeof;

import lombok.Data;

/**
 * @Classname LongObject
 * @Description long  Long  Object  map 内存占用测试   ps:引用关系占4个字节
 * @Date 2020/2/27 13:42
 * @Created by qiziqian
 */
@Data
public class LongObject {


    //   占用堆内存 24   (8 markword +  8 klass  +4引用 +4引用)
    Long test1;
    //  占用总内存 40  4个字节的引用  + 8 markword +  8 klass + 24


    // Long test2;
}

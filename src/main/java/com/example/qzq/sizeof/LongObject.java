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
    //   占用堆内存 24   (8 markword 8 klass  +4引用 +4引用)
    // 4个字节的引用   占用总内存 24   (24 +24 +24)
    Long test1;
    Long test2;
    //8个字节的实际类型
    //   long test1;
    //   long test2;
}

package com.example.qzq.iosteam;

import java.io.*;

/**
 * @ClassName : ReaderTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-17 13:33
 */
public class ReaderTest {

    public static void main(String[] args) throws IOException {

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(("C:\\Users\\qiziqian\\Desktop\\test.txt")));
            System.out.println("读取到数据: " + bufferedReader.readLine());
            bufferedReader.close();
        }
    }
}
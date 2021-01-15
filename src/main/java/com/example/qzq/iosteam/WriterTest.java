package com.example.qzq.iosteam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName : WriterTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-17 13:37
 */
public class WriterTest {

    public static void main(String[] args) throws IOException {
        String s1 = "12345";
        String s2 = "12346";
        boolean flag = true;
        while (true) {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\qiziqian\\Desktop\\test.txt"));
            if (flag) {
                bufferedWriter.write(s2);
                flag = false;
            } else {
                bufferedWriter.write(s1);
                flag = true;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }


    }
}
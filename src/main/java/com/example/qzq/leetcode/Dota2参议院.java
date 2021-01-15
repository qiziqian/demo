package com.example.qzq.leetcode;

/**
 * @ClassName : Dota2参议院
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-12-11 10:22
 */
public class Dota2参议院 {
    public String predictPartyVictory(String senate) {
        boolean R = true, D = true;
        int flag = 0;
        StringBuilder stringBuilder = new StringBuilder(senate);
        while (R && D) {
            R = false;
            D = false;
            for (int i = 0; i < stringBuilder.length(); i++) {
                if (stringBuilder.charAt(i) == 'R') {
                    if (flag < 0) stringBuilder.replace(i, i, "0"); // 消灭R，R此时为false
                    else R = true; // 如果没被消灭，本轮循环结束有R
                    flag++;
                }
                if (stringBuilder.charAt(i) == 'D') {
                    if (flag > 0) stringBuilder.replace(i, i, "0");
                    else D = true;
                    flag--;
                }
            }
        }
        return R ? "Radiant" : "Dire";
    }


}
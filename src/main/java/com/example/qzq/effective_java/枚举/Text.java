package com.example.qzq.effective_java.枚举;

import java.util.EnumSet;
import java.util.Set;

/**
 * @Classname Text
 * @Description
 * @Date 2020/4/23 14:41
 * @Created by qiziqian
 */
public class Text {
    public enum Style{BOLD,ITALIC,UNDERLINE,STRIKETHROUGH}
    public static  void applyStyles(Set<Style> styles){
        System.out.println(styles);
    }
    public static void main(String[] args) {
        applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
    }
}

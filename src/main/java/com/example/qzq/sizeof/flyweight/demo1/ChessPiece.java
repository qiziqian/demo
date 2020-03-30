package com.example.qzq.sizeof.flyweight.demo1;

/**
 * @Classname ChessPiece
 * @Description
 * @Date 2020/3/9 9:45
 * @Created by qiziqian
 */
public class ChessPiece {
    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static enum Color {RED, BLACK}
}

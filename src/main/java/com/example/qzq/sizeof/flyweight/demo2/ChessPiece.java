package com.example.qzq.sizeof.flyweight.demo2;

/**
 * @Classname ChessPiece
 * @Description
 * @Date 2020/3/9 9:48
 * @Created by qiziqian
 */
public class ChessPiece {
    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    } // 省略getter、setter方法
}

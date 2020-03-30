package com.example.qzq.sizeof.flyweight;

import com.example.qzq.sizeof.flyweight.demo1.ChessPiece;
import com.example.qzq.sizeof.flyweight.demo2.ChessPieceUnit;
import org.apache.lucene.util.RamUsageEstimator;

/**
 * @Classname SizeTest
 * @Description
 * @Date 2020/3/9 9:49
 * @Created by qiziqian
 */
public class SizeTest {
    public static void main(String[] args) {
        ChessPiece chessPiece1 = new ChessPiece(1, "马", ChessPiece.Color.BLACK, 1, 1);
        ChessPieceUnit chessPieceUnit = new ChessPieceUnit(1, "马", ChessPieceUnit.Color.BLACK);
        com.example.qzq.sizeof.flyweight.demo2.ChessPiece chessPiece2 = new com.example.qzq.sizeof.flyweight.demo2.ChessPiece(chessPieceUnit, 1, 1);
//        System.out.println(RamUsageEstimator.humanSizeOf(chessPiece1));
//        System.out.println(RamUsageEstimator.humanSizeOf(chessPieceUnit));
//        System.out.println(RamUsageEstimator.humanSizeOf(chessPiece2));
        System.out.println(RamUsageEstimator.shallowSizeOf(chessPiece1));
        System.out.println(RamUsageEstimator.shallowSizeOf(chessPieceUnit));
        System.out.println(RamUsageEstimator.shallowSizeOf(chessPiece2));
        System.out.println((32 * 30 * 10000 - (24 * 30 * 10000 + 24 * 30)) / 1024 + "kb");
    }
}

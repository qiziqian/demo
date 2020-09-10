package com.example.qzq.work;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.net.DatagramPacket;
import java.time.LocalDateTime;
import java.util.Arrays;


/**
 * @ClassName : CRCTest
 * @Author : qiziqian
 * @Description:
 * @Date: 2020-08-25 10:14
 */
public class CRCTest {
    public static void main(String[] args) {
        //byte[] bytes ={ 0x01,0x03,0x02,0x02,(byte)0x92,(byte)0xFF,(byte)0x9B,(byte)0xD2,0x3D};
        //byte[] bytes ={ 0x01,0x03,0x02,0x02,(byte)0x92,(byte)0xFF,(byte)0x9B};
        // byte[] bytes ={0x01,0x03,0x04,0x02,(byte)0xA5,0x01,(byte)0x2F,(byte)0xAB,(byte)0xE4};
        // byte[] bytes ={0x03,0x04,0x02,(byte)00,00,00,00,00};
        //byte[] bytes = {0x01,0x03,0x04,0x02,(byte)0xAB,0x01,0x2D,0x4B,(byte)0xE6,0x00};
        byte[] bytes = {0x01, 0x03, 0x04, 0x02, (byte) 0xAF, 0x01, 0x2C, (byte) 0xCB, 0x00};

        byte[] dataBytes = Arrays.copyOfRange(bytes, 0, 7);
        byte[] crcBytes = Arrays.copyOfRange(bytes, 7, 9);
        String encode = HexBin.encode(crcBytes);
        String result = checkDataReasonable(dataBytes);
        System.out.println(encode);
        System.out.println(result);
        System.out.println(encode.equals(result));
        verifyDataAndCRC(bytes);
        convertAndWrap(bytes);
    }

    //温湿度数据格式转换
    public static int convert(byte[] bytes) {
        int i = 0;
        if (bytes[0] != -1) {
            String encode = HexBin.encode(bytes);
            i = Integer.parseInt(encode, 16);
        } else {
            i = bytes[1];
        }
        return i;
    }

    /**
     * 计算CRC16校验码
     *
     * @param bytes
     * @return
     */
    public static String checkDataReasonable(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        CRC = ((CRC & 0x0000FF00) >> 8) | ((CRC & 0x000000FF) << 8);
        return Integer.toHexString(CRC).toUpperCase();
    }

    /**
     * Author qiziqian
     * Description   对比数据的crc结果和传来的crc校验码
     * Date  2020/8/25
     **/
    public static boolean verifyDataAndCRC(byte[] data) {
        byte[] dataBytes = Arrays.copyOfRange(data, 0, 7);
        byte[] crcBytes = Arrays.copyOfRange(data, 7, 9);
        String crcCode = HexBin.encode(crcBytes);
        String dataCode = checkDataReasonable(dataBytes);
        return dataCode.equals(crcCode);
    }

    public static void convertAndWrap(byte[] data) {
        //拿到指定数据位
        byte[] humidityBytes = Arrays.copyOfRange(data, 3, 5);
        byte[] temperatureBytes = Arrays.copyOfRange(data, 5, 7);
        //转换和封装数据
        double humidity = (double) convert(humidityBytes) / 10;
        double temperature = (double) convert(temperatureBytes) / 10;
        String time = LocalDateTime.now() + "";

    }
}
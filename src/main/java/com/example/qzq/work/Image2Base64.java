package com.example.qzq.work;

import lombok.extern.log4j.Log4j2;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: Miaojiaxing
 * @Description: 将图片转化为base64的字符串
 * @Date: Create in 10:37 2019/7/19
 */
@Log4j2
public class Image2Base64 {
    public static void main(String[] args) {
        String s = imageToBase64("https://fastgw-ali.ys7.com/1/capture/2020/10/14/l0jxzjiro4w5bgd981xf3bi8.jpg?Expires=1602741783&OSSAccessKeyId=LTAIzI38nEHqg64n&Signature=SHJRN0CRUHdSm3NQWjcXWeGOgHc%3D&bucket=ezviz-fastdfs-gateway");
        System.out.println(s);
    }

    public static String imageToBase64(String netImagePath) {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            URL url = new URL(netImagePath);
            byte[] bytes = new byte[1024];
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            InputStream inputStream = connection.getInputStream();
            int length = -1;
            while ((length = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(out.toByteArray());
    }
}

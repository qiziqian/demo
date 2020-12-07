package com.example.qzq.work;

import lombok.extern.log4j.Log4j2;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.util.PublicSuffixMatcher;
import org.apache.http.conn.util.PublicSuffixMatcherLoader;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.util.FileCopyUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class HttpClientUtil {
    /**
     * setConnectionRequestTimeout(config.connReqTimeout)   //从连接池中获取连接的超时时间
     * setConnectTimeout(config.connTimeout)      //连接请求URL超时时间
     * setSocketTimeout(config.socketTimeout)   //socket读数据超时时间：从服务器获取响应数据的超时时间
     */
    private static RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(20000)
            .setConnectTimeout(20000)
            .setSocketTimeout(20000)
            .build();

    public static void main(String[] args) throws IOException {
        String s = sendHttpsGet("https://fastgw-ali.ys7.com/1/capture/2020/10/14/l0jxzjiro4w5bgd981xf3bi8.jpg?Expires=1602741783&OSSAccessKeyId=LTAIzI38nEHqg64n&Signature=SHJRN0CRUHdSm3NQWjcXWeGOgHc%3D&bucket=ezviz-fastdfs-gateway",
                new ArrayList<>(), "");
        System.out.println(s);
    }

    public static void setTimeout(int timeout) {
        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(20000)
                .setConnectTimeout(20000)
                .setSocketTimeout(timeout)
                .build();
    }

    public static void resetTimeout() {
        requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(20000)
                .setConnectTimeout(20000)
                .setSocketTimeout(20000)
                .build();
    }


    /**
     * 发送Get请求
     *
     * @param httpUrl https://tool.bitefu.net/jiari/
     * @param headers
     * @param params  d=2018
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendHttpGet(String httpUrl, List<Header> headers, String params)
            throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            if (params != null && !params.isEmpty()) {
                httpUrl = httpUrl + "?" + params;
            }
            // 创建get请求
            HttpGet httpGet = new HttpGet(httpUrl);
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 添加get请求头
            if (headers != null && !headers.isEmpty()) {
                for (Header tmp : headers) {
                    httpGet.addHeader(tmp);
                }
            }
            // 执行请求
            response = httpClient.execute(httpGet);

            if (response != null) {
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } else {
                throw new IOException();
            }
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 发送Get请求Https
     *
     * @param httpUrl https://tool.bitefu.net/jiari/
     * @param params  d=2018
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String sendHttpsGet(String httpUrl, List<Header> headers, String params) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String responseContent = null;
        try {
            if (params != null && !params.isEmpty()) {
                httpUrl = httpUrl + "?" + params;
            }
            // 创建get请求
            HttpGet httpGet = new HttpGet(httpUrl);
            // 创建默认的httpClient实例.
            PublicSuffixMatcher publicSuffixMatcher = PublicSuffixMatcherLoader
                    .load(new URL(httpGet.getURI().toString()));
            DefaultHostnameVerifier hostnameVerifier = new DefaultHostnameVerifier(publicSuffixMatcher);
            httpClient = HttpClients.custom().setSSLHostnameVerifier(hostnameVerifier).build();
            httpGet.setConfig(requestConfig);
            if (headers != null && !headers.isEmpty()) {
                for (Header tmp : headers) {
                    httpGet.addHeader(tmp);
                }
            }
            // 执行请求
            response = httpClient.execute(httpGet);
            InputStream inputStream = response.getEntity().getContent();
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\testPricture.jpg"));
            FileCopyUtils.copy(inputStream, fileOutputStream);
            // 读返回数据
            responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }


    /**
     * 发送Post请求 Http
     *
     * @param httpUrl 地址
     * @param params  参数(格式:key1=value1&key2=value2) 使用contentType:  application/x-www-form-urlencoded
     * @param params  参数(格式:{\"key1\":\"value1\",\"key1\":\"value1\"} 使用contentType:  application/json
     * @throws IOException
     * @throws ClientProtocolException
     */
    public static String sendHttpPost(String httpUrl, String params, String contentType, List<Header> headers) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        StringEntity stringEntity = null;
        String responseContent = null;
        try {
            httpClient = HttpClients.createDefault();
            //创建httpPost
            HttpPost httpPost = new HttpPost(httpUrl);
            //设置参数
            stringEntity = new StringEntity(params, "UTF-8");
            //发送json数据需要设置contentEncoding
            stringEntity.setContentType(contentType);
            stringEntity.setContentEncoding("UTF-8");
            if (headers != null && !headers.isEmpty()) {
                for (Header tmp : headers) {
                    httpPost.addHeader(tmp);
                }
            }
            httpPost.setEntity(stringEntity);
            httpPost.setConfig(requestConfig);
            response = httpClient.execute(httpPost);
            //读返回数据
            responseContent = EntityUtils.toString(response.getEntity(), "UTF-8");
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }


}

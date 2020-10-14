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

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
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

    public static void main(String[] args) {
        try {
            String s = sendHttpGet("http://127.0.0.1:8888/q", new ArrayList<>(), "");
        } catch (IOException e) {
            System.out.println("打印");
        }
    }
}

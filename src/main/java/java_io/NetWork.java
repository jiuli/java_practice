package java_io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * NetWork
 * 网络操作：Socket
 *
 * @author lijunsong
 * @date 2021/5/25 17:08
 * @since 1.0
 */
@Slf4j
public class NetWork {
    @SneakyThrows
    public static void main(String[] args) {

        URL url = new URL("http://news.qq.com");
        /**
         * 字节流
         */
        InputStream in = url.openStream();
        /**
         * 字符流
         */
        InputStreamReader inr = new InputStreamReader(in, "utf-8");
        /**
         * 提供缓存功能
         */
        BufferedReader bufferedReader = new BufferedReader(inr);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            log.info(line);
            log.info("\n");
        }
        bufferedReader.close();

        /**
         * Java 中的网络支持：
         *
         * InetAddress：用于表示网络上的硬件资源，即 IP 地址；
         * URL：统一资源定位符；
         * Sockets：使用 TCP 协议实现网络通信；
         * Datagram：使用 UDP 协议实现网络通信。
         */
    }
}

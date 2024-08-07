package cn.irez.doc;

import cn.hutool.core.net.NetUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocApplication {
    private static Integer port;

    @Value("${server.port:8080}")
    public void setPort(Integer port) {
        DocApplication.port = port;
    }

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class);

        String serverIP = NetUtil.getLocalhostStr();

        System.out.println("swagger文档生 maven -> plugins -> smart-doc -> smart-doc:openapi");
        System.out.printf("接口文档：http://%s:%s/doc.html\r\n", serverIP, port);
    }
}

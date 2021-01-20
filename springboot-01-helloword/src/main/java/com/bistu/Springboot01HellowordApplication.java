package com.bistu;



import com.bistu.utils.TcpSendAndRecv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;

//@SpringBootApplication：标注这个类是一个springboot的应用,启动类下的所有资源被导入
@SpringBootApplication
public class Springboot01HellowordApplication extends SpringBootServletInitializer {
    //将springboot应用启动
    public static void main(String[] args) {
        new TcpSendAndRecv().run();
        System.out.println("已开启新线程");
        SpringApplication.run(Springboot01HellowordApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }
}

package com.liko.nettyc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by likoguan on 6/12/18.
 */
@ComponentScan(basePackages = {"com.liko.nettyc.service"})
@SpringBootApplication
public class NettycApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NettycApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("NettycApplication run");
        LikoClient client = new LikoClient("127.0.0.1", 7777);
        client.connect();
    }
}


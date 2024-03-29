package com.shin.vg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.shin"})
public class VarGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(VarGeneratorApplication.class, args);
    }

}


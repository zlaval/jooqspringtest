package com.zlrx.jooqdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
@EnableTransactionManagement
public class JooqdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JooqdemoApplication.class, args);
    }

}

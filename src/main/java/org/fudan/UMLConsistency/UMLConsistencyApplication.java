package org.fudan.UMLConsistency;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zlyang
 * @date: 2022-04-03 10:17
 * @Description:
 */
@SpringBootApplication
public class UMLConsistencyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UMLConsistencyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command Runner");
    }
}

package org.fudan.UMLConsistency;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author: zlyang
 * @date: 2022-04-04 13:15
 * @description:
 */
public class UMLInstanceTest {

    @Test
    public void readTest() throws IOException {
        Scanner scanner = new Scanner(new ClassPathResource("test/instance.txt").getInputStream());
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(!s.isEmpty() && s.charAt(0) == '!'){
                System.out.println(s);
            }
        }
    }

}

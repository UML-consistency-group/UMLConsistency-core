package org.fudan.UMLConsistency;

import org.fudan.UMLConsistency.service.OptHandler;
import org.fudan.UMLConsistency.service.StreamInputResolver;
import org.fudan.UMLConsistency.uml.UMLInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author: zlyang
 * @date: 2022-04-04 13:15
 * @description:
 */
@SpringBootTest
public class UMLInstanceTest {

    @Autowired
    private StreamInputResolver streamInputResolver;

    @Autowired
    private OptHandler createHandler;


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

    @Test
    public void createTest(){
        String s;
        while((s = streamInputResolver.getNext()) != null){
            UMLInstance umlInstance = createHandler.handleOpt(s);
            System.out.println(umlInstance);
        }
    }

    @Test
    public void splitTest(){
        String operation = "assh hhh    jjj ss ";
        String [] attrs = operation.split("\\s+");
        for(int i=0;i< attrs.length;i++){
            System.out.println(attrs[i]);
        }
    }


    @Test
    public void testReadFromStream(){
        String s;
        while((s = streamInputResolver.getNext()) != null){
            System.out.println(s);
        }
    }

}

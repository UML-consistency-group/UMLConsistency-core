package org.fudan.UMLConsistency;

import org.junit.jupiter.api.Test;

/**
 * @author: zlyang
 * @date: 2022-04-06 23:05
 * @description:
 */
public class SimpleTest {
    @Test
    public void tempTest(){
        String[] split = "car1.registrationNumber".split("\\.");
        for (String s : split) {
            System.out.println(s);
        }
    }
}

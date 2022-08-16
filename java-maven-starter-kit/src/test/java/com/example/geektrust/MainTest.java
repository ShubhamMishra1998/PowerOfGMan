package com.example.geektrust;


import com.example.geektrust.solution.GManPower;
import com.example.geektrust.solution.GManPowerImpl;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testMain(){
        String source="SOURCE 2 1 E";
        String destination="DESTINATION 4 3";
        GManPower gManPower=new GManPowerImpl(source,destination);
        assertEquals(155,gManPower.getPower());

    }

    @Test
    void testMain1(){
        String source="SOURCE 0 5 W";
        String destination="DESTINATION 6 1";
        GManPower gManPower=new GManPowerImpl(source,destination);
        assertEquals(90,gManPower.getPower());

    }

    @Test
    void testMain2(){
        String source="SOURCE 3 6 N";
        String destination="DESTINATION 1 0";
        GManPower gManPower=new GManPowerImpl(source,destination);
        assertEquals(110,gManPower.getPower());

    }

    @Test
    void testMain3(){
        String source="SOURCE 2 1 E";
        String destination="DESTINATION 3 2";
        GManPower gManPower=new GManPowerImpl(source,destination);
        assertEquals(175,gManPower.getPower());

    }

    @Test
    void testMain4(){
        String source="SOURCE 0 0 E";
        String destination="DESTINATION 6 6";
        GManPower gManPower=new GManPowerImpl(source,destination);
        assertEquals(75,gManPower.getPower());

    }
    @Test
    void testMainMethod() throws FileNotFoundException {
        String[] args = {"C:\\Users\\Shubham_Mishra1\\Documents\\Java-Codes\\GeekTrust\\PowerOfGMan\\java-maven-starter-kit\\sample_input\\input1.txt"};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("C:\\Users\\Shubham_Mishra1\\Documents\\Java-Codes\\GeekTrust\\PowerOfGMan\\java-maven-starter-kit\\sample_input\\input1.txt"));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
    }


}
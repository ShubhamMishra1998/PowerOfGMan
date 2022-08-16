package com.example.geektrust;

import com.example.geektrust.solution.GManPower;
import com.example.geektrust.solution.GManPowerImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(FileInputStream fis=new FileInputStream(args[0])){
             Scanner sc=new Scanner(fis);
            List<String> inputString=new ArrayList<>();
            while (sc.hasNextLine()) {
              inputString.add(sc.nextLine());
            }
            GManPower gManPower=new GManPowerImpl(inputString.get(0),inputString.get(1));
            System.out.println("POWER "+gManPower.getPower());


        }catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}

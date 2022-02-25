package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bankomat bankomat = new Bankomat(scanner);
        bankomat.start();
    }
}

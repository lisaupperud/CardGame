package com.annalisa.cardgame.util;

import java.util.Scanner;

public class ScannerUtility {

    private static final Scanner sc = new Scanner(System.in);

    public static int scanInt() {
        return sc.nextInt();
    }

    public static void closeScanner() {
        sc.close();
    }
}

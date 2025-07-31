package org.TestProject;

import java.util.ArrayList;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // 1.   Java program to find Fibonacci series upto a given number range
//            fiboSeries(9);
        // 2.   Java program to find Prime number
//            primeNum(22);
        // 3.   Java program to Find Factorial on given Number
//            factorial(5);
        // 4.   Java program to Reverse Number
                reverseNum(123);
        // 5.    Java program to find Armstrong Number

    }

    private static void reverseNum(int num) {

    }

    private static void factorial(int num) {
        int result=1;
        for (int i = 1; i <= num; i++) {
            result = result*i;
            System.out.println(result);
        }

        System.out.println("Factorial for number "+num+" is: "+result);
    }

    private static void primeNum(int i) {


        if (isPrime(i)){
            System.out.println(i+" is Prime number");
        }else {
            System.out.println(i+" Not a Prime Number");
        }

    }

    private static boolean isPrime(int num){

        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    private static void fiboSeries(int seriesLenght) {

        int firstNum =0, secondNum = 1, next;


        for (int i = 0; i < seriesLenght ; i++) {
            System.out.print(firstNum+" ");
            next = firstNum + secondNum;
            firstNum=secondNum;
            secondNum=next;

        }

    }
}
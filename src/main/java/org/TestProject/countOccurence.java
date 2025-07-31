package org.TestProject;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class countOccurence {

    public static void main(String[] args) {


//        removeDuplicates("aibnidfa");/**//*/

//        palindromeNum(454);
//        int num = 45 , rev = 0;
//
//        if (plaindroneRecursive(num,rev)== num){
//            System.out.println("Palindrome");
//        }else
//            System.out.println("Not Palindromme");

    }

 public static int palindromeRucursive(int num, int rev){
        if(num == 0)
            return rev;

        int rem = num % 10;
        rev = (rev*10)+rem;

        return palindromeRucursive(num/10, rev);
 }

    public static void palindromeNum(int number){
        int rev ,sum=0,temp;

        temp=number;
        while (number>0){
            rev = number%10;
            sum = (sum*10)+rev;
            number = number/10;
            System.out.println("inside while: "+sum);
        }
//        System.out.println(rev);

        if (sum == temp){
            System.out.println(temp+" is a palindrome Number");
        }else {
            System.out.println(temp+" is Not palindrome Number");
        }
    }

    public static void removeDuplicates(String string){
        Arrays.stream(string.split("")).distinct().forEach(System.out::println);
    }

    public static void occurenceOfWords(String string){
        List<String> words ;
        words = Arrays.asList(string.split(" "));
        HashMap<String,Integer> counts = new HashMap<>();
        words.stream().forEach(word ->{
            if (counts.containsKey(word)){
                counts.put(word,counts.get(word)+1);
            }else {
                counts.put(word,1);
            }
        });

        System.out.println(counts);

    }

    private static void countNumberWithoutHashMap(String str) {

        int[] countChars = new int[256];

        for (char c: str.toCharArray()){
            countChars[c]++;
        }

        for (int i=0; i< countChars.length;i++){
            if (countChars[i]>0){
                System.out.println((char) i +" : "+countChars[i]);
            }
        }


    }

    public static void countNumberOcurence(String string){
        HashMap<Character,Integer> countChars = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            if (countChars.containsKey(string.charAt(i))){
                countChars.put(string.charAt(i), countChars.get(string.charAt(i))+1);
            }else{
                countChars.put(string.charAt(i),1);
            }
        }
    }
}

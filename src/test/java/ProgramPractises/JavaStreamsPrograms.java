package ProgramPractises;

import org.apache.commons.lang3.stream.IntStreams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreamsPrograms {


    public static void main(String[] args) {

        String[] fruits = {"Banana","Mango","Dates","WaterMelon"};
        String[] words = {"asdjk","12434","iuahs","3732"};
        String[] anagrams = {"pat","tap","nap","pan","tree","team","meat"};
        int[] arr = {1,2,3,4,6};

        //Give a map with word and its lenght
//        displayingWordAndLenght(fruits);

        //01 Given a sentence, find the word that has the highest length
//        highestLenght("Disconnected from the target");

        //02 remove duplicates and print in the same order
//        removeDuplicatesAndOrder("dsaaodgg");

        //03 2nd highest word
//        secondHighestWord("I am Learning Streams in an Interviews");

        //37 Group list of strings by their first character and count the number of strings
        //41 Convert a list of string to uppercase and then concatenate
        //52 | Print the count of a particular substring
        streamOp(anagrams);

        //27 Find the kth smallest element in a list of integers
        // 28 Remove all non-numeric characters from a list.
        //29 Find and print strings containing only digits.
        //31 Calculate the average of all the numbers
        //32 Find the intersection of two lists using Java streams
        //49 | Print distinct numbers which starts with "1" in descending order
//        streamIntOp(arr);

        //06 find the words with a specified number of vowels
        //06 find the words with a specified number of vowels
//        streamOperationsOnString("finding the the occurence in the sentence in API");


        // 07 from the given Int array divide the even and odd list

//        streamOperationsOnIntList(arr);
//        streamOnString("llo world");
//        streamDiffOps();

    }

    private static void streamDiffOps() {

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Supplier<Stream<Integer>> numStream = ()  -> list.stream();
        //Consumption 1
        numStream.get().forEach(System.out::print);
        //consumption 2
        numStream.get().sorted().mapToInt(Integer::intValue).min();

    }

    private static void streamIntOp(int[] arr) {
//        27 Find the nth smallest element in a list of integers
        List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int n = 3;
        int nthInt = integerList.stream().sorted().distinct().skip(n-1).findFirst().get();
        System.out.println("27 : Find the nth smallest element in a list of integers");
        System.out.println(nthInt);

        // 28 Remove all non-numeric characters from a list.
        String[] alphanum = {"1ah3k4","j5k2k6","8s94n2","143"};
        List<String> alphanumlist = Arrays.stream(alphanum).collect(Collectors.toList());
        Pattern pattern = Pattern.compile("[^0-9]");

        List<String> ans = alphanumlist.stream().map(words -> pattern.matcher(words).replaceAll(""))
                .collect(Collectors.toList());
        System.out.println("// 28 Remove all non-numeric characters from a list.");
        System.out.println(ans);

        //29 Find and print strings containing only digits.
        List<String> result = alphanumlist.stream().filter(ele -> ele.matches("\\d")).collect(Collectors.toList());
        System.out.println("// 29 Find and print strings containing only digits.");
        System.out.println(result);

        //31 Calculate the average of all the numbers
        double avg = integerList.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
        System.out.println("//31 Calculate the average of all the numbers");
        System.out.println(avg);

        //32 Find the intersection of two lists using Java streams
        List<Integer> lInt1 = Arrays.asList(1,2,3,4);
        List<Integer> lInt2 = Arrays.asList(3,4,5,6);

        List<Integer> commonEle = lInt1.stream().filter(lInt2::contains).collect(Collectors.toList());
        //              replacement for this
//        List<Integer> comnFile = lInt1.stream().filter(ele-> lInt2.contains(ele)).collect(Collectors.toList());
        System.out.println(commonEle);


//        34 Generate the first 10 numbers of the Fibonacci Sequence
        List<Integer> fibonaccilist = Stream.iterate(new int[]{0,1},
                f -> new int[]{f[1],f[0]+f[1]}).limit(10).map(f -> f[0]).collect(Collectors.toList());
        System.out.println("34 Generate the first 10 numbers of the Fibonacci Sequence");
        System.out.println(fibonaccilist);

        //49 | Print distinct numbers which starts with "1" in descending order
        int[] arr12 = {1,2,156,75,247,157,11} ;
        List<Integer> startwith1 = Arrays.stream(arr12).distinct()
                .filter(num -> String.valueOf(num).startsWith("1"))
                .boxed().collect(Collectors.toList());
        System.out.println("//49 | Print distinct numbers which starts with \"1\" in descending order");
        System.out.println(startwith1);

    }

    private static void streamOp(String[] array) {
        //create a list that contains only integers
        List<Integer> list =Arrays.stream(array).filter(nums -> nums.matches("[0-9]+")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("//create a list that contains only integers");
        System.out.println(list);

//        Group /Pair anagrams from a list of Strings
        List<String> list1 = Arrays.asList(array);

        Map<Object,List<String>> analist =list1.stream().collect(Collectors
                .groupingBy(
                        words -> Arrays.stream(words.toLowerCase().split("")).sorted().collect(Collectors.toList())));
        System.out.println(" Group /Pair anagrams from a list of Strings");
        System.out.println(analist);

        //Given the string[] group the strings based on the middle character
        System.out.println("Given the string[] group the strings based on the middle character");
        System.out.println(Stream.of(array).collect(Collectors.groupingBy(words -> words.charAt(words.length()/2))));

        //26 Find the union of two lists of integers
        List<String> L1 = Arrays.asList("as","ass","asss");
        List<String> L2 = Arrays.asList("bs","bss","bsss");

        Stream.concat(L1.stream(),L2.stream()).collect(Collectors.toList());

        //30 Convert a list of strings to uppercase.
        System.out.println("30 Convert a list of strings to uppercase.");
        Arrays.stream(array).map(String::toUpperCase).forEach(System.out::print);
        System.out.println(" ");

        //37 Group list of strings by their first character and count the number of strings
        Map<Character,Long> charcount =list1.stream().map(words -> words.charAt(0))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("//37 Group list of strings by their first character and count the number of strings");
        System.out.println(charcount);

        //41 Convert a list of string to uppercase and then concatenate
        String concat = list1.stream().map(String::toUpperCase).reduce(((string1, string2) -> string1+""+string2)).get();
        System.out.println(concat);

        //52 | Print the count of a particular substring
        String string = "byebyeBirdiebye";
        String subString = "bye";
        long count =IntStream.range(0,string.length()-2).filter(x->string.substring(x,x+3).equals(subString)).count();
        System.out.println("//52 | Print the count of a particular substring");
        System.out.println(count);
    }

    private static void streamOnString(String string) {
        //Given a string, find the first non-repeated character
//        String firstchar= Arrays.stream(string.split("")).distinct().findFirst().get();
//        System.out.println(firstchar);
                                    //  OR

        /*
            Here we are checking the first and last index if both are same means the
            character is distinct else character is repeated "Hello World" ==> indexOf("L")=2 and lastIndexOf("L") =9

        */


        String str = Arrays.stream(string.split("")).
                filter(chars -> string.indexOf(chars) == string.lastIndexOf(chars)).
                filter(chars -> !chars.equals(" ")).findFirst().get();
        System.out.println("Given a string, find the first non-repeated character");
        System.out.println(str);


        //Given a string, find the first repeated character

        Map<String,Long> map = Stream.of(string.split("")).collect(Collectors
                .groupingBy(Function.identity(),Collectors.counting()));

        String ch = map.entrySet().stream().filter(entry-> entry.getValue()>1).map(entry -> entry.getKey()).findFirst().get();
        System.out.println("Given a string, find the first repeated character");
        System.out.println(ch);


    }

    private static void streamOperationsOnIntList(int[] arr) {

        // 07 from the given Int array divide the even and odd list
        List<Integer> even = Arrays.stream(arr).filter(num-> num%2==0).mapToObj(num-> (Integer)num).toList();
        System.out.println(even);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Map<Boolean,List<Integer>> map =list.stream().collect(Collectors.groupingBy(num -> num %2==0 , Collectors.toList()));
        System.out.println(map);
                                    //      OR
        List<List<Integer>> list1 =list.stream().collect(Collectors.groupingBy( num -> num%2==0 , Collectors.toList()))
                .entrySet().stream().map(x-> x.getValue()).collect(Collectors.toList());
        System.out.println(list1);

        //                      To Get rthe sum of the list you can add .sum() at the end retunType int

//        Map<Boolean,Integer> map = Arrays.stream(arr).collect(Collectors.groupingBy(num->(Integer) num%2==0),Collectors.toList());

        //group the numbers by the range
        int[] array = {4,8,39,31,85,83,20,21};
        List<Integer> list2 = Arrays.stream(array).boxed().collect(Collectors.toList());
        Map<Integer,List<Integer>> map2 = list2.stream().collect(Collectors.groupingBy(num->num/10*10, LinkedHashMap::new,Collectors.toList()));
        System.out.println("//group the numbers by the range");
        System.out.println(map2);


        // Find the products of the first two elements in an array
        int ans =Arrays.stream(array).limit(2).reduce(1,(a,b)-> a*b);
        System.out.println(" Find the products of the first two elements in an array");
        System.out.println(ans);


        //Write a stream program to multiply alternative numbers in an array
        int inte =IntStream.range(0, arr.length).filter(i-> i%2==0).map(x->arr[x]).reduce(1,(a,b)-> a*b);
        System.out.println("//Write a stream program to multiply alternative numbers in an array");
        System.out.println(inte);

//        Write a program to multiply 1st and last element, 2nd and 2nd last element etc.
        System.out.println("Write a program to multiply 1st and last element, 2nd and 2nd last element etc.");
        IntStream.range(0,arr.length/2).map(i -> arr[i]*arr[arr.length-1-i]).forEach(System.out::println);

//        Write a stream program to move all zero’s to beginning of array
        int[] mixZeroes = {7,3,0,1,0,4,0,0};
        List<Integer> integerList = Arrays.stream(mixZeroes).boxed().toList();
        List<Integer> zeroes= integerList.stream().filter(num -> num == 0).toList();
        List<Integer> nonZeroes= integerList.stream().filter(num -> num != 0).toList();
        List<Integer> result = new ArrayList<>();
        result.addAll(zeroes);
        result.addAll(nonZeroes);
        System.out.println("Write a stream program to move all zero’s to beginning of array");
        System.out.println(result);

//        In a given array of integers, return true if it contains distinct values

        List<Integer> intList = Arrays.stream(mixZeroes).boxed().collect(Collectors.toList());
        Map<Integer,Long> intmap =intList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("In a given array of integers, return true if it contains distinct values");
        System.out.println(intmap.values().stream().noneMatch(x-> x>1));


    }

    public static void streamOperationsOnString(String string){

        //05 Find the occurence
        Map<String,Long> map = Stream.of(string.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        //06 find the words with a specified number of vowels
        Arrays.stream(string.split(" ")).filter(words -> words.replaceAll("[^aeiouAEIOU]","").length()==2)
                .forEach(System.out::println);

    }


    public static void secondHighestWord(String string){


        String word=Stream.of(string.split(" ")).sorted( (a,b) -> (b.length() - a.length())).skip(1).findFirst().get();
        System.out.println(word);
    }

    private static void removeDuplicatesAndOrder(String string) {
//        Stream.of(string.split("")).distinct().forEach(System.out::print);

        string.chars().mapToObj(obj -> (char)obj).distinct().forEach(System.out::print);
    }

    public static void highestLenght(String string){

//        List<String> list =
       Stream.of(string.split(" ")).sorted((a, b)->(b.length() - a.length())).limit(1).forEach(string1 -> {
           System.out.println(string1+" : "+string1.length());
       });



    }

    private static void displayingWordAndLenght(String[] arr) {

        Map<String,Integer> map = Arrays.stream(arr).collect(Collectors.toMap(fruit -> fruit,String::length));
        System.out.println(map);


    }
}

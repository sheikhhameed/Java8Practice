package com.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Practice from the url : https://www.w3resource.com/java-exercises/stream/index.php
 */
public class StreamTestPractice {

//    from url:
    public static void main(String[] args){

//        calculateAverageOfListInteger();
//        secondSmallestAndLargest();
//        int[] arr= {6,3,2};
//        boolean result = firstlast6(arr);
//        System.out.println("result:"+result);
//        Integer[] arr = {2,4,6};
        List<Integer> arrlist = Arrays.asList(2,4,6);
        List<List<Integer>> response = subset(arrlist);
        response.stream().forEach(System.out::println);
    }

    public static void secondSmallestAndLargest(){
        //Write a Java program to find the second smallest and largest elements in a list of integers using streams.
        List<Integer> value = Arrays.asList(1,4,5,6,7,8,9,10,21,33,56);
        //first approch
//        Optional<Integer> secondlargest = value.stream().distinct().sorted((a,b)->Integer.compare(b,a)).skip(1).findFirst();
        //second approach
        Optional<Integer> secondlargest = value.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();


        System.out.println("value:"+secondlargest.get());
    }

    public static void test(){
        List < Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        Integer secondLargest = nums.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);

//        System.out.println("\nSecond smallest element: " + secondSmallest);
        System.out.println("\nSecond largest element: " + secondLargest);
    }
    public static void maxAndMinimum(){
        //Write a Java program to find the maximum and minimum values in a list of integers using streams.
        List<Integer> value = Arrays.asList(1,3,4,6,7,8,9,21);
        Optional<Integer> maxvalue = value.stream().max(Integer::compareTo);
        System.out.println("max: "+maxvalue.get());
        Optional<Integer> minvalue = value.stream().min(Integer::compareTo);
        System.out.println("min: "+minvalue);
    }

    public static void sortAscendingDescending(){
        // Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams
        List<String> strlist = Arrays.asList("AllIsWell", "Thank You", "Welcome", "BestofLuck","Care");
        List<String> sortedAscending = strlist.stream().sorted().collect(Collectors.toList());
        sortedAscending.forEach(System.out::println);

        List<String> sorteddecending = strlist.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        sorteddecending.forEach(System.out::println);

    }
    public static void countNumberofStringInListStartWithSpecificletter(){
//Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    List<String> strlist = Arrays.asList("Hello", "Thanks", "Welcome","Hi", "Hey");
    long count = strlist.stream().filter(n->n.startsWith("H")).count();
    System.out.println("valu:"+count);
    }
    public static void removeDuplicateElement(){
        List<String> strlist = Arrays.asList("a","b","a","c");
        List<String> result = strlist.stream().distinct().collect(Collectors.toList());
        result.forEach(System.out::println);
    }
    public static void sumofAllOddEven(){
//Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List<Integer> intlist = Arrays.asList(1,2,3,4,5);

        int evenList = intlist.stream().filter(n->n%2==0).mapToInt(Integer::intValue).sum();
        int oddlist = intlist.stream().filter(n->n%2!=0).mapToInt(Integer::intValue).sum();
        System.out.println("value even: "+evenList);
        System.out.println("value odd: "+oddlist);
    }

    public static void convertStringToUpperOrLowerCase(){
        //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
        List<String> strlist =Arrays.asList("Hello","world");

        List<String> uppercase = strlist.stream().map(n->n.toUpperCase()).collect(Collectors.toList());
        List<String> lowercase = strlist.stream().map(n->n.toLowerCase()).collect(Collectors.toList());
        uppercase.forEach(System.out::println);
        lowercase.forEach(System.out::println);//System.out.println(str.toUpperCase());

    }
    private static void calculateAverageOfListInteger() {
        //Write a Java program to calculate the average of a list of integers using streams.
        List<Integer> intlist = Arrays.asList(1,2,3,4,5);
        OptionalDouble avearge = intlist.stream().mapToDouble(Integer::doubleValue).average();
        System.out.println("val:"+avearge);
    }


    /**
     * result
     * firstLast6([1, 2, 6]) → true
     * firstLast6([6, 1, 2, 3]) → true
     * firstLast6([13, 6, 1, 2, 3]) → false
     *
     * @param nums
     * @return
     */
    private static boolean firstlast6(int[] nums){
//        IntStream stream = Arrays.stream(nums).filter(a-> a==6).anyMatch(value -> );
        boolean flag =false;
            if(nums[0]==6 ||(nums[nums.length-1]==6)){
                flag=true;
            }
        return flag;
    }

    //input :{1, 4 ,9} output : {1, 4 ,9}, {1, 4}, {1, 9}, {4, 9}, {1}, {4}, {9}, and {}.
    public static List<List<Integer>> subset(List<Integer> list){
        if(list.isEmpty()){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans =subset(rest);
        List<List<Integer>> subans2 = insertAll(first,subans);
        return concat(subans,subans2);
    }

    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {

        subans.addAll(subans2);
        return subans;
    }

    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {

        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> list: subans){
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }
}

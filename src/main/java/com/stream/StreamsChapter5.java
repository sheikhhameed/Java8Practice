package com.stream;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Find all transactions in the year 2011 and sort them by value (small to high).
 * 2. What are all the unique cities where the traders work?
 * 3. Find all traders from Cambridge and sort them by name.
 * 4. Return a string of all traders’ names sorted alphabetically.
 * 5. Are any traders based in Milan?
 * 6. Print all transactions’ values from the traders living in Cambridge.
 * 7. What’s the highest value of all the transactions?
 * 8. Find the transaction with the smallest value.
 */
public class StreamsChapter5 {


    Traders raoul = new Traders("Raoul", "Cambridge");
    Traders mario = new Traders("Mario","Milan");
    Traders alan = new Traders("Alan","Cambridge");
    Traders brian = new Traders("Brian","Cambridge");


    List<Transactions> transactions = Arrays.asList(
            new Transactions(brian,2011, 300),
            new Transactions(raoul,2012,1000),
            new Transactions(raoul, 2011, 400),
            new Transactions(mario, 2012,710),
            new Transactions(mario,2012,700),
            new Transactions(alan,2012,950));

    //Find all transactions in the year 2011 and sort them by value (small to high).
    public static List<Transactions> getAllTransaction(List<Transactions> transactions){
        List<Transactions> getTransaction = transactions.stream()
                .filter(transaction-> transaction.getYear()==2011)
                .sorted(Comparator.comparing(Transactions::getValue))
                .collect(Collectors.toList());

        return getTransaction;
    }

    public List<String> uniqueCities(Traders traders){
        List<String> uniqCities = new ArrayList<>();
//        traders.
        return uniqCities;
    }
    public static void main(String[] args){

        StreamsChapter5 obj = new StreamsChapter5();
//        List<Traders>
        List<Integer> intlist = Arrays.asList(1,2,3,4,5);
        Optional<Integer> result =  intlist.stream().reduce(Integer::sum);//.forEach(System.out::println);
    System.out.println("result: "+result.get());
        seriesResultWithGenerateMethod();
//        List<Transactions> tr2011 = obj.getAllTransaction(transactions);
//

    }
    // example of iterate method
    // result : (0, 1), (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21)....
    //Your task is to generate the first 20 elements of the series of Fibonacci tuples using the iterate
    //method!
    public static void seriesResultWithIterateMethod(){
        Stream.iterate(new int[]{0, 1},
                        t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
    }

    public static void seriesResultWithGenerateMethod(){
        IntSupplier supplier = new IntSupplier() {
            private int previous =0;
            private int current =1;
            @Override
            public int getAsInt() {
                int Oldprevious = previous;
                int nextvalue = this.previous+this.current;
                this.previous=this.current;
                this.current=nextvalue;
                return Oldprevious;
            }
        };
        IntStream.generate(supplier).limit(10).forEach(System.out::println);
    }
}

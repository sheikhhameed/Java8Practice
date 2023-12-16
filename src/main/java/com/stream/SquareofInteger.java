package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SquareofInteger {

    public static void main(String[] args){
        List<Integer> intvalue = Arrays.asList(1,2,3,4,5);

        List<Integer> squareList = intvalue.stream()
                .map(val-> val*val)
//                .forEach(a->System.out.println(a)).reduce()
                .collect(Collectors.toList());
        squareList.forEach(a-> System.out.println("value:"+a));

    }
}

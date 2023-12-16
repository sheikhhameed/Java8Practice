package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//not completed
public class PairOfElement {

    public static void main(String[] args){
        List<Integer> first = Arrays.asList(1,2,3);
        List<Integer> second = Arrays.asList(3,4);
//        result : [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].


        List<Integer[]> pair =
                first.stream()
                .flatMap(i-> second.stream().map(j->new Integer[]{i,j}) )
//                        .forEach();
                        .collect(Collectors.toList());

        pair.stream().flatMap(Arrays::stream).forEach((i)->System.out.println(i+" val "+i.intValue()));


    }
}

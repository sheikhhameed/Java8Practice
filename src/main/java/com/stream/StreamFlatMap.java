package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMap {

    public static void main(String[] args){

        List<String> strList = Arrays.asList("Hello","World");

          strList.stream()
                .map(s-> s.split(""))
                  .flatMap(Arrays::stream)
                  .distinct()
                .forEach(System.out::println);

//        for(String[] val:flist){
//            System.out.println("value:"+val);
//        }

    }

}

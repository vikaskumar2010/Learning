package com.learn.java8;
/*
 * Reference: http://howtodoinjava.com/core-java/collections/java-8-tutorial-streams-by-examples/
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        /*
         * Intermediate operations : filter, map, sorted
         * Terminal operations : collect, reduce, forEach
         */
        
        //mapDemo();
        //filterDemo();
        //sortedDemo();
        //forEachDemo();
        reduceDemo();
        
    }
    

    public static void mapDemo() {
        
        /*The map method is used to map the items in the collection to other objects according to the Predicate passed as argument.
         * The collect method is used to return the result of the intermediate operations performed on the stream.
         */
        List<Integer> number = Arrays.asList(2,3,4,5);
        System.out.println("Number:"+number);
        List<Integer> square = number.stream().map(x->x*x).collect(Collectors.toList());
        System.out.println("Square:"+square);
    }

    public static void filterDemo() {
        /*
         * The filter method is used to select elements as per the Predicate passed as argument.
         */
        List<String> names = Arrays.asList("Reflection","Collection","Stream","Abc","Star");
        System.out.println("Names:"+names);
        List<String> result=names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
        System.out.println("Filter Result:"+result);
    }

    public static void sortedDemo() {
        /*
         * The sorted method is used to sort the stream.
         */
        List<String> names = Arrays.asList("Reflection","Collection","Stream","Abc","Star");
        System.out.println("Names:"+names);
        List<String> result=names.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted Result:"+result);
    }

    public static void forEachDemo() {
        /*
         *  The forEach method is used to iterate through every element of the stream.
         */
        List<Integer> number = Arrays.asList(2,3,4,5);
        number.stream().map(x->x*x).forEach(y->System.out.println(y));
    }
    public static void reduceDemo() {
        /*
         * The reduce method is used to reduce the elements of a stream to a single value.
         * The reduce method takes a BinaryOperator as a parameter.
         */
        List<Integer> number = Arrays.asList(2,3,4,5,6,7,8);
        int summOfEvenNum = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        System.out.println("Sum of even numbers:"+summOfEvenNum);
    }
}

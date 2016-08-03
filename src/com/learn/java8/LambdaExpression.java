
package com.learn.java8;

import java.util.function.Predicate;

public class LambdaExpression {
    public static void main(String[] args) {
        LambdaExpression demo = new LambdaExpression();
        /* How to create own functional interface and uses in lambda expression */
        //demo.testLambdaExpression1();
        
        /* Existing functional interface and  lambda expressions*/
        demo.testLambdaExpression2();
        
    }

   
    
    public void testLambdaExpression1() {

        /* without lambda expression */
        //Anonymous class has the calculate implementation to add x and y
        performCalculation(5, 3, new MyFunctionalInterface() {

            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        });
        //Anonymous class has the calculate implementation to multiply x and y
        performCalculation(5, 3, new MyFunctionalInterface() {

            @Override
            public int calculate(int x, int y) {
                return x * y;
            }
        });

        /* with lambda expression */
        //lambda expression basically has the calculate implementation for subtraction x-y.
        performCalculation(5, 3, (a, b) -> (a - b));

    }
    
    public void testLambdaExpression2() {
        /* without lambda expression*/
        testMethod(5, new Predicate<Integer>() {

            @Override
            public boolean test(Integer t) {
                return t%2==0;
            }
        });
     
        /* with lambda expression */
        testMethod(5, (a)->(a%2==0));
    }
    
    public void performCalculation(int a, int b, MyFunctionalInterface operation) {
        System.out.println("Result:" + operation.calculate(a, b));
    }
    public void testMethod(int x,Predicate<Integer> p){
        System.out.println("testMethod called. Result is :"+p.test(x));
    }
}

/*
 * Annotation is not neccessary, using this will just force you to use only one abstract method.
 * Function Interface can have only one abstract method and any number default methods.
 * Lambda expressions can be used only in functional interface.
 */
@FunctionalInterface
interface MyFunctionalInterface {
    public int calculate(int x, int y);

    default void testMethod() {
        System.out.println("This is a default method of functional interface.");
    }
}
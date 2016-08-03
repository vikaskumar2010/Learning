/*
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *  
 *  @version     1.0, 03-Aug-2016
 *  @author vikas
 */
package com.learn.java8;

public class LambdaExpression {
    public static void main(String[] args) {
        LambdaExpression demo = new LambdaExpression();
        /* How to create own functional interface and uses in lambda expression */
        demo.testLambdaExpression1();
        
        /* Existing functional interface and  lambda expressions*/
        
        
    }

    public void testLambdaExpression2() {
        
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

    public void performCalculation(int a, int b, MyFunctionalInterface operation) {
        System.out.println("Result:" + operation.calculate(a, b));
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
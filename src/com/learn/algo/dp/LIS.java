package com.learn.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Ref : http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * Problem:
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest 
 * subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order. 
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("LIS:"+getLengthOfLIS(arr));
    }
    
    public static int getLengthOfLIS(Integer[] arr){
        Integer lis[] = new Integer[arr.length];
        Arrays.fill(lis, 1);
        
        for(int i=1;i<arr.length;i++){
            //System.out.println("i="+i+"arr[]"+arr[i]);
            for(int j=i-1;j>=0;j--){
                //System.out.println("j="+j+"arr[]"+arr[j]);
                if(arr[j]<arr[i]&&lis[i]<lis[j]+1){
                    lis[i]=1+lis[j];
                    //System.out.println("setting lis-"+i+" to "+lis[i]);
                }
            }
        }
        System.out.println(Arrays.asList(lis));
        int max=1,index=0;
        for(int i=1;i<lis.length;i++){
            if(max<lis[i]){
                max=lis[i];
                index = i;
            }
        }
        //finding the LIS 
        List<Integer> resultIndex = new ArrayList<Integer>();
        resultIndex.add(index);
        int prevIndex = index;
        
        for(int i=index-1;i>=0;i--){
            if(arr[i]<arr[prevIndex]&&lis[i]==max-resultIndex.size()){
                resultIndex.add(i);
            }
        }
        System.out.println("LIS index"+resultIndex);
        List<Integer> result = new ArrayList<Integer>();
        for(int i=resultIndex.size()-1;i>=0;i--){
            result.add(arr[resultIndex.get(i)]);
        }
        System.out.println("Final LIS result:"+result);
        return max;
    }

}

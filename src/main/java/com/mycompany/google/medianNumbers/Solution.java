/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.medianNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author skliz
 */
public class Solution {
    
    public static void test(){
        
        System.out.println("test values ");
        
        List<Double> answers = runningMedian(Arrays.asList(10, 1,2,3,4,5,6,7,8,9,10));
        
        System.out.println(answers);
    }
    
     public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here

        Collections.sort(a, Comparator.naturalOrder());

        List<Double> answer = new ArrayList();
        
        if(a != null)
        if(a.size() >0){
            float result = a.get(0);
            answer.add((double)result);
        }
       
        if(a.size() > 1){
            BigDecimal v1 =BigDecimal.valueOf( a.get(0));
            
            BigDecimal v2 = BigDecimal.valueOf( a.get(1));
            
            BigDecimal result = v1.add(v2);
            result = result.divide(BigDecimal.valueOf(2));
            
            result = roundValue(result);
            
            answer.add(result.doubleValue());
        }
        
        if(a.size() >2){
           // System.out.println("imsdfsd");
            
            for(int k=3; k <a.size(); k++){
                //System.out.println("ddddddddddddddddd");
                
                 int middle = k;
                if(k%2 == 0){ //even
                    
                    middle /= 2;
                    BigDecimal v1 = BigDecimal.valueOf(a.get(middle-1));
                    
                   BigDecimal v2 =  BigDecimal.valueOf(a.get(middle));
                   
                   BigDecimal result = v1.add(v2);
                   
                   result = result.divide(BigDecimal.valueOf(2));
                    
                 result = roundValue(result);
                 
                 answer.add(result.doubleValue());
                }
                else{
                   middle = (k-1)/2;
                   middle +=1;
                   
                   BigDecimal v = BigDecimal.valueOf(a.get(middle-1));
                   
                   v = roundValue(v);
                   
                   answer.add(v.doubleValue());
                }
            }
        }

        return answer;
    }


    public static BigDecimal roundValue(BigDecimal bd){

        bd = bd.round(new MathContext(2));
       // double rounded = bd.doubleValue();
       
       System.out.println(bd);
       return bd;
    }
     
}

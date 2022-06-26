/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.median2arrs;

/**
 *
 * @author skliz
 */
public class Median2arr {
    
    public static void test(){
        
        double result = solve(new int[]{1,3},new int[]{2} );
        
        System.out.println("result [1, 3] [2] --> "+result);
        
        
        result = solve(new int[]{1,2},new int[]{3, 4} );
        
        System.out.println("result [1, 2] [3,4] --> "+result);
    }
    
    public static double solve(int[] arr1, int[] arr2){
        
        float median1 = 0, median2 = 0;
        
        int size1 = arr1.length; int size2 = arr2.length;
        
        int stoplen = (size1 > size2 ) ?  size1 : size2;
        
        int i=0;
        while(i<stoplen){
            
            if(i < size1)
            median1 += arr1[i];
            
            if(i< size2)
                median2 += arr2[i];
            
            i++;
        }
        
        median1 /= size1;  median2 /= size2;
        
        double result = (median1 + median2)/2;
        
       
        return  result;
    }
    
}

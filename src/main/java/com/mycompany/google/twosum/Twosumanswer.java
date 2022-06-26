/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.twosum;

import java.util.Arrays;

/**
 *
 * @author skliz
 */
public class Twosumanswer {
    
    public static void test(){
        
        int[] numbers = {2,7,11,15};
        
        int[] answer =solve(numbers, 9);
        
        System.out.println("Solution Two sum numbers "+Arrays.toString(answer));;
    }
    
    public static int[] solve(int[] numbers, int target){
        
        Arrays.sort(numbers);
        
        int[] answer = new int[2];
        
        for(int k=0; k<numbers.length; k++){
            
            int result = target - numbers[k];
            
            int posIndex = Arrays.binarySearch(numbers, result);
            
            if(posIndex >-1){
                
                if(posIndex > k){
                    answer[0] = k; answer[1] = posIndex;
                }
                else
                    answer[0] = posIndex; answer[1] = k;
            }
        }
        
        return answer;
    }
    
}

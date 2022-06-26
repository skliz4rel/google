/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.longestSubNochar_repeat;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author skliz
 */
public class SubstrNocharRepeat {
    
   
    
    public static void test(){
        
        int result = solve("abcabcbb");
        System.out.println("test abcabcbb ->  "+result);
        
        result = solve("bbbbb");
        System.out.println("test bbbbb ->  "+result); //"
        
        
        result = solve("pwwkew");
        System.out.println("test pwwkew ->  "+result);
    }
    
    public static int solve(String str){
        int  longest = 0;
        
        HashSet<Character> substring = new HashSet<>();
        
        for(int k=0; k< str.length(); k++){
            
            if(substring.contains(str.charAt(k))){
              int current =  substring.size();
              
              if(current > longest){
                  longest = current;
              }
              
              substring.clear();
            }
            else{
                substring.add(str.charAt(k));
            }
        }
        
        return longest;
    }
}

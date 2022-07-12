/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.longestPanlindrome;

/**
 *
 * @author skliz
 */

//This returns the longest pallindrome string
public class LongestPanlindrome {
    
   
    
    public static void test(){
        
        String result = solve("babad");
        
        System.out.println("test1 babad ->   "+result);
        
        
        result = solve("cbbd");
        
        System.out.println("test2 cbbd ->   "+result);
    }
    
    
    //Time Complexity O(n)  Explanation: Everything happens in one loop. and we iterate to just the mid point of the loop
    //Space Complexity O(n)  Explanation: We made use of String and StringBuilders, This are deriaved datatypes in java. that need n memory locations to store value.
    public static String solve(String s){
        
        String longestPanlindrome = "";
        
        if(s == null) return "";
        
        if(s.length() == 0 || s.length() > 2000) return "";  //According to the question it invalid input
        
        
        for(int start=0, end=s.length(); start<s.length(); start++, end--){
            
            if(start == s.length()/2){
                break;
            }
            
            String frontToEnd = s.substring(start, s.length());
            String centerStr = s.substring(start, end);
            String EndToFront = s.substring(start,s.length());
            
            String result = returnLongestPalindrome(frontToEnd, centerStr,EndToFront);
            
            if(result.length() > longestPanlindrome.length()){
                longestPanlindrome = result;
            }
        }
        
        return longestPanlindrome;
    }
    
    public static String returnLongestPalindrome(String s1, String s2, String s3){
        
        String longest = "";
        
        StringBuilder s1Reverse =  new StringBuilder(s1);
        StringBuilder s2Reverse = new StringBuilder(s2);
        StringBuilder s3Reverse = new StringBuilder(s3);
        
        s1Reverse.reverse(); s2Reverse.reverse(); s3Reverse.reverse();
        
        if(s1.equalsIgnoreCase(s1Reverse.toString())){
            if(s1.length() > longest.length()){
                longest = s1;
            }
        }
        
        if(s2.equalsIgnoreCase(s2Reverse.toString())){
            if(s2.length() > longest.length()){
                longest = s2;
            }
        }
        
         if(s3.equalsIgnoreCase(s3Reverse.toString())){
            if(s3.length() > longest.length()){
                longest = s3;
            }
        }
         
         return longest;
    }
    
    
    
}

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

//This is going to return the lenght 
public class LongestPanlindrome1 {
    
    private static int longestPanlindrome = 0;
    
    public static void test(){
        
    }
    
    public static int solve(String s){
        
        if(s == null) return 0;
        
        if(s.length() == 0 || s.length() > 2000) return 0;  //According to the question it invalid input
        
        
        for(int start=0, end=s.length(); start<s.length(); start++, end--){
            
            String frontToEnd = s.substring(start, s.length());
            String centerStr = s.substring(start, end);
            String EndToFront = s.substring(0,end);
            
            int result = returnLongestPalindrome(frontToEnd, centerStr,EndToFront);
            
            if(result > longestPanlindrome){
                longestPanlindrome = result;
            }
        }
        
        return longestPanlindrome;
    }
    
    public static int returnLongestPalindrome(String s1, String s2, String s3){
        
        int longest = 0;
        
        StringBuilder s1Reverse =  new StringBuilder(s1);
        StringBuilder s2Reverse = new StringBuilder(s2);
        StringBuilder s3Reverse = new StringBuilder(s3);
        
        s1Reverse.reverse(); s2Reverse.reverse(); s3Reverse.reverse();
        
        if(s1.equalsIgnoreCase(s1Reverse.toString())){
            if(s1.length() > longest){
                longest = s1.length();
            }
        }
        
        if(s2.equalsIgnoreCase(s2Reverse.toString())){
            if(s2.length() > longest){
                longest = s2.length();
            }
        }
        
         if(s3.equalsIgnoreCase(s3Reverse.toString())){
            if(s3.length() > longest){
                longest = s3.length();
            }
        }
         
         return longest;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author skliz
 */
public class MyArrays {

    
    public static String replace(List<Replacement> replaces, String originalStr) throws IllegalArgumentException{
        
        String newStr = originalStr;
            
        for(Replacement r : replaces){
            
            if(originalStr.substring(r.start, r.start+r.before.length()).equals(r.before) == false){
                throw new IllegalArgumentException("word not found");
            }
            else{
                newStr = doReplace(newStr, r.before, r.after, r.start);
                //originalStr = newStr;
            }
        }
        
        return newStr;
    }
    
    private static String doReplace(String originalStr, String oldStr, String newStr, int start ){
        
        String newString = "";
        char[] charArray = originalStr.toCharArray();
        
        for(int k=0; k<charArray.length; k++){
            
            if(k == start){
                newString += newStr;
            }else if(k >start && k <= (start+oldStr.length()-1)){
                continue;
            }
            else{
                newString += charArray[k];
            }
        }
        
        return newString;
    }
    
}
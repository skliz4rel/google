/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.interview;

import static com.mycompany.google.interview.MyArrays.replace;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skliz
 */
public class Usebugger {
    
    public static void test(){
         List<Replacement> list = new ArrayList();
        
        //String originalStr = "I am in love with you am";
        
         String originalStr = "abcfab";
        
        
        Replacement r = new Replacement();
        //r.start = 2;
        //r.before = "am";
        r.start=0;
        r.before = "ab";
        r.after = "yy";
        list.add(r);
        
        
        r = new Replacement();
        //r.start = 2;
        //r.before = "am";
        r.start=4;
        r.before = "ab";
        r.after = "xx";
        list.add(r);
        
        try{
        String newString = replace(list, originalStr);
        
        System.out.println(newString);
                
        System.out.println();
        
        System.out.println("Second approach to solve this question  ");
        System.out.println(Usebugger.replace(list, originalStr));
        }
        catch(Exception e){
            System.err.println("There was an error  "+e.getMessage() +" "+e.getCause());
        }
    }
          
    public static String replace(List<Replacement> replaces, String originalStr) throws IllegalArgumentException{
        
       StringBuffer buffer = new StringBuffer(originalStr);        
       
       for(Replacement r : replaces){
           
           if(originalStr.indexOf(r.before, r.start) < 0){
           
                throw new IllegalArgumentException ("Wrong search key passed, Does not exits in the original string");
            }
           else{
               
              buffer =  buffer.replace(r.start, r.start+r.before.length(), r.after);
           }
       }
       
       return buffer.toString();
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google;

import com.mycompany.google.interview.Usebugger;
import com.mycompany.google.interview.Replacement;
import static com.mycompany.google.interview.MyArrays.replace;
import com.mycompany.google.longestPanlindrome.LongestPanlindrome;
import com.mycompany.google.longestSubNochar_repeat.SubstrNocharRepeat;
import com.mycompany.google.median2arrs.Median2arr;
import com.mycompany.google.medianNumbers.Solution;
import com.mycompany.google.twosum.Twosumanswer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author skliz
 */
public class Main {
    
    
        public static void main(String[] args){
            
           // System.out.println("check this   "+Math.floor(1.5)+"  "+Math.round(1.5));
            
            Twosumanswer.test();
            System.out.println();
        
            Usebugger.test();
            
            SubstrNocharRepeat.test();
            
            Median2arr.test();
            
            LongestPanlindrome.test();
            
            Solution.test();
    }
 

}
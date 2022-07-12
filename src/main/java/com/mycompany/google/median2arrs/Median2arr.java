/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.google.median2arrs;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author skliz
 */
public class Median2arr {
    
    public static void test(){
        
        double result = findMedianSortedArrays(new int[]{1,3},new int[]{2} );
        
        System.out.println("result [1, 3] [2] --> "+result);
        
        
        result = findMedianSortedArrays(new int[]{1,2},new int[]{3, 4} );
        
        System.out.println("result [1, 2] [3,4] --> "+result);
    }
    
    
      public static double findMedianSortedArrays(int[] nums1, int[] nums2){
          
          if(nums1 == null && nums2 == null){
              return 0.0;
          }
        
        BigDecimal result = new BigDecimal("0.0");
       
        int size1 = 0,  size2 = 0, totalsize = 0;
        
        if(nums1 != null && nums1.length >0){
            size1 = nums1.length;
        }
        
        if(nums2 != null && nums2.length >0){
            size2= nums2.length;
        }
        
        if(size1 > 0 && size2 == 0){
            result = forSingleArray(nums1, size1);
            
            return result.doubleValue();
        }
        
       if(size1 == 0 && size2 > 0){
            result = forSingleArray(nums2, size2);
            
            return result.doubleValue();
        }
        
        
        totalsize += size1 + size2;
        
        boolean isEven = (totalsize %2 == 0) ? true : false;
        
        int index1= 0, index2 = 0;//This would store the index of median numbers
        
        if(isEven){
            // 1 2 3 4
            int middleNumber = totalsize/2;
            index1 = middleNumber-1;  index2 = middleNumber;
        }
        else{
            // 1 2 3 4 5
            int middleNumber = ((totalsize-1)/2)+1;
            
            index1 = middleNumber-1;
        }
        
        if(nums1[nums1.length-1] < nums2[0]){
              // Create a formula to extract the middle number
            //[ 1 2 ] [3 4 5 6 7] 

            //0 1 2 3 4 5 6
      
            result = checkIfbothArraysfollowOrder( isEven, nums1, nums2, size1, size2, totalsize, index1, index2);
        }
        else{
            
            result = whenSecondArrIsextractof1stArr( isEven, nums1, nums2, size1, size2, totalsize, index1, index2);
        }   
        
        return result.doubleValue();
      }
      
      public static BigDecimal forSingleArray(int[] array, int size){
          
          BigDecimal result = null;
          boolean isEven = size % 2== 0 ? true : false;
          
          if(isEven){
              
              int divisor = size/2;
              
              BigDecimal first = BigDecimal.valueOf(array[divisor-1]);
              BigDecimal second = BigDecimal.valueOf(array[divisor]);
              
              result = first.add(second);
              
              result = result.divide(BigDecimal.valueOf(2));
          }
          else{
              int index = (size -1)/2+1;
              
              result = BigDecimal.valueOf(array[index-1]);
          }
          
          return result;
      }
    
      public static BigDecimal whenSecondArrIsextractof1stArr(boolean isEven,int[] nums1, int[] nums2,int size1, int size2, int totalsize, int index1,int index2){
         
          BigDecimal result = null;
          
          //[1 5 ] [ 2 3 4]  =  [ 1 2 3 4 5]
         
          //in the new imaginary list
          int _1stArr1ItemPos =0, _lastArr1itempos = totalsize-1;
        
          int _1stArr2ItemPos = nums1.length-1; 
          int _lastArr2ItemPos =0;
          
       
          
          if(nums2.length > 1){
             _lastArr2ItemPos =  _1stArr2ItemPos +(nums2.length-1);
          }
          
           System.out.println(_1stArr1ItemPos+" secondblock  "+_lastArr1itempos);
           
            System.out.println(_1stArr2ItemPos+" secondblock  "+_lastArr2ItemPos);
          
          if(isEven){
              
                
            BigDecimal firstMid = null;
            BigDecimal secondMid = null;
            
            int mid1 = 0, mid2 =0;
            
            if(index1 >= _1stArr1ItemPos && index1 < _1stArr2ItemPos){
                
                mid1 = nums1[index1];
            }
            if(index1 == _1stArr2ItemPos){
                mid1 = nums2[0];
            }
            
            if(size2 > 1){
                if(index1 > _1stArr2ItemPos && index1 <  _lastArr2ItemPos){
                    mid1 = nums2[index1+_1stArr2ItemPos];
                }

                if(index1 == _lastArr2ItemPos){
                    mid1 = nums2[_lastArr2ItemPos];
                }

                if(index1 >_lastArr2ItemPos && index1 < _lastArr1itempos){
                    mid1 = nums1[index1 + _lastArr2ItemPos];
                }
            }
            //Getting the index for the second middle number
            
             if(index2 >= _1stArr1ItemPos && index2 < _1stArr2ItemPos){
                
                mid2 = nums1[index2];
            }
            if(index2 == _1stArr2ItemPos){
                mid2 = nums2[0];
                
            }
            
            if(size2 > 1){
                if(index2 > _1stArr2ItemPos && index2 <  _lastArr2ItemPos){
                    mid2 = nums2[index2 +_1stArr2ItemPos];
                }

                if(index2 == _lastArr2ItemPos){
                    mid2 = nums2[_lastArr2ItemPos];
                }

                if(index2 >_lastArr2ItemPos && index2 < _lastArr1itempos){
                    mid2 = nums1[index2 + _lastArr2ItemPos];
                }
            }
            
            firstMid = BigDecimal.valueOf(mid1);
            secondMid = BigDecimal.valueOf(mid2);
                   
            result = firstMid.add(secondMid);
            
            result = result.divide(BigDecimal.valueOf(2));
          }
          else{
              
            int mid1 = 0;
              
            //System.out.println("was a odd number "+index1);
            
            if(index1 >= _1stArr1ItemPos && index1 < _1stArr2ItemPos){
                
                mid1 = nums1[index1];
            }
            if(index1 == _1stArr2ItemPos){
              
                
                mid1 = nums2[0];
                
                //  System.out.println("got here again  "+mid1);
            }
            
            
            if(size2 > 1){
                if(index1 > _1stArr2ItemPos && index1 <  _lastArr2ItemPos){
                    mid1 = nums2[index1+_1stArr2ItemPos];
                }

                if(index1 == _lastArr2ItemPos){
                    mid1 = nums2[_lastArr2ItemPos];


                    //System.out.println("got here  "+_lastArr2ItemPos);
                }

                if(index1 >_lastArr2ItemPos && index1 < _lastArr1itempos){
                    mid1 = nums1[index1 + _lastArr2ItemPos];

                    //System.out.println("the problem  ");
                }
            }
            
            result= BigDecimal.valueOf(mid1);
          }
          
         // System.out.println(Arrays.toString(nums1) + " ** "+Arrays.toString(nums2) );
         // System.out.println(_1stArr2ItemPos+"  "+_lastArr2ItemPos);
 
          return result;
     }
      
      
      public static BigDecimal checkIfbothArraysfollowOrder(boolean isEven,int[] nums1, int[] nums2,int size1, int size2, int totalsize, int index1,int index2){
         
          BigDecimal result = null;
         
             if(isEven){
            
            BigDecimal firstMid = null;
            BigDecimal secondMid = null;
            
            int mid1 = 0, mid2 =0;
            
            if(size1 > index1){
                mid1 = nums1[index1];
            }
            else{
                int lastIndex_arr1 = nums1.length-1;
                
                int m = (index1 - lastIndex_arr1)-1;
                
                mid1 = nums2[m];
            }
            
            if(size1 > index2){
                mid2 = nums1[index2];
            }
            else{
                 int lastIndex_arr1 = nums1.length-1;
                 
                 int m = (index2 - lastIndex_arr1)-1;
                 mid2 = nums2[m];
            }
            
            firstMid = BigDecimal.valueOf(mid1);
            secondMid = BigDecimal.valueOf(mid2);
                   
            result = firstMid.add(secondMid);
            
            result = result.divide(BigDecimal.valueOf(2));
        }
        else{
            int mid1 = 0;
            
            if(size1 > index1){
                mid1 = nums1[index1];
            }
            else{
                 int lastIndex_arr1 = nums1.length-1;
                
                int m = (index1 - lastIndex_arr1)-1;
                
                mid1 = nums2[m];
            }
            
            result = BigDecimal.valueOf(mid1);
        }
             
         return result;
      }
  
}

package com.selftraining.datastructures;

import java.util.HashMap;
import java.util.Map;

public class CrashArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CrashArrays localObj = new CrashArrays();
//		String result = localObj.traverseArray("Hello");
		
//		System.out.println("Test Result Traverse String : "+result);
		
//		System.out.println("Test Result Sorted Array ");
//		
//		int arr1[] = {4,6,10};
//		
//		int arr2[] = {1,2,3,4,9};
//				
//		int sorted[] = localObj.mergeSortedArrays(arr1, arr2);
//		for(int i : sorted)
//			System.out.println("Item Value "+i);
		
		System.out.println("Test Two Sum Algorithm");
		int [] source = {6,5,7,8,9,3};
		int result [] = localObj.twoSumOfArrayByMap(source , 10);
		
		for(int i : result)
			System.out.println("Result Value "+i);
		
		//Run with Enhanced HashMap Solution
//		System.out.println("Test Two Sum Algorithm");
//		int [] source = {6,5,7,8,9,3};
//		int result [] = localObj.twoSum(source , 10);
//		
//		for(int i : result)
//			System.out.println("result Value "+i);
		
	}
	 public String traverseArray(String text)
	    {
	        int textLength = text.length();
	        
	        //this way will cause a bigger space complexity to convert string to array of characters
	        //char[] textArr = text.toCharArray();
	        
	        char revArray [] = new char[text.length()];
	        
	        
	        //Time Complexity O(n)
	        for(int i = textLength -1 ; i >= 0 ; i --)
	        {
	        	//Instead of array of characters use built in method char at
	        	revArray[(i- (textLength -1)) * -1] = text.charAt(i);
	        }
	        
//	        for(int i = textLength-1 ; i >= 0 ; i --)
//	        {
//	            revArray[(i- (textLength -1)) * -1] = textArr[i];
//	        }
	        
	        String reversed  = new String(revArray);
	        
	        return reversed;
	        
	    }


	 //this solution will result in time complexity O(n) and space of O(n1 + n2) = O(n) =====> Worst Case
	 public int[] mergeSortedArrays(int[] arr1 , int[] arr2)
	 {
		 //array length

		 int n1 = arr1.length;
		 int n2 = arr2.length;
		 
		 //result sorted array
		 int [] result = new int[arr1.length+arr2.length];
		 
		 //check input
		 if(n1 == 0 && n2 == 0)
			 return result;
		 else if(n1 == 0 && n2 > 0)
			 return arr2;
		 else if(n1 > 0 && n2 == 0 )
			 return arr2;
		 
		 //Start Algorithm
		 else
		 {
			 int i = 0,j = 0 ,k = 0 ;
			 
			 //check if first item smaller than second item in array , if yes put it in result array
			 //otherwise put second item in result array
			 while(i < n1 && j < n2)
			 {
				 if(arr1[i] < arr2[j])
					 result[k++] = arr1[i++];
				 else
					 result[k++] = arr2[j++];
			 }
			 
			 //remaining of first array
			 // length param of array copy is the number of array elements to be copied which is n1 - already copied elements (i OR j)
			 //Using System.arraycopy definitely wins with larger arrays performance wise
			 if(i < n1)
				 System.arraycopy(arr1, i, result, k, n1-i);
			 
			 if(j < n2)
				 System.arraycopy(arr2, j, result, k, n2-j);
			 
//			 while(i < n1)
//			 {
//				 result[k++] = arr1[i++];
//			 }
//			 
//			 //remaining of second array
//			 while(j < n2)
//			 {
//				 result[k++] = arr2[j++];
//			 }
			 return result;
		 }
	 }
	 
	 /*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

			 You may assume that each input would have exactly one solution, and you may not use the same element twice.

			 Example:

			 Given nums = [2, 7, 11, 15], target = 9,

			 Because nums[0] + nums[1] = 2 + 7 = 9,
			 return [0, 1].
	 */
	 //not valid solution because of saving array values as key depend on no duplicates in source array but this may happen
	 //but enhanced to be working as required by looping over source array itself not keys of map
	 public int[] twoSumOfArrayByMap(int [] source , int target)
	 {
		 int [] result = new int [2];
		 
		 //input validation check
		 if(source == null || source.length == 0 || source.length < 2)
			 return null;
		 
		 int firstItem = source[0];
		 int secondItem = source[1];
		 int length = source.length;
		 int lastItem = source[length - 1 ];
		 int secondLastItem = source[length - 2 ];
		 
		 if(source.length == 2 && ((target - firstItem) == secondItem))
		 {
			result[0] = 0 ;
			result [1]  = 1;
			return result;
		 } 
		 else if(source.length == 2)
			 return null;
		 else
		 {
			//Best Scenario Check
			 if((target - firstItem)== secondItem)
			 {
			 	result[0] = 0 ;
				result [1]  = 1;
				return result;
			 }
			 
			 if((target - lastItem) == secondLastItem)
			 {
				 result[0] = length - 1 ;
				result [1] = length - 2;
				return result;
			 }
			 
			 //Start Algorithm
			 
			 //1st put array source in Map with Key value pair
			 HashMap<Integer,Integer> sourceMap = new HashMap<>();
			 for (int i = 0 ; i < length ; i ++)
			 {
				 //Fill Map
				 sourceMap.put(source[i], i);
				 System.out.println("Filled Map" + sourceMap);
			 }
			 
			 //check if target - map key is exist
			 for(int i = 0 ;i < length ; i ++)
			 {
				 int currentItemValue = i;
				 System.out.println("Current Item Index " + currentItemValue);
				 int complement = target - source[i];
				 System.out.println("complement " + complement );
				 if( sourceMap.containsKey(complement) && sourceMap.get(complement) != i)
				 {
					 result[0] = i;
					 //return index of complement
					 result[1] = sourceMap.get(complement);
					 return result;
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 //enhanced solution with hash map
	 public int[] twoSum(int[] nums, int target) {
		    Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        map.put(nums[i], i);
		    }
		    System.out.println("Filled Map" + map);
		    
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        
		        int currentItemValue = i;
				 System.out.println("Current Item Index " + currentItemValue);
				 
				 System.out.println("complement " + complement );
				 //&& map.get(complement) != i this condition means that the complement is not number it self and this known by check it is not exist in same place i
		        if (map.containsKey(complement) && map.get(complement) != i ) {
		            return new int[] { i, map.get(complement) };
		        }
		    }
		    //Cover all possible checks for not valid inputs
		    throw new IllegalArgumentException("No two sum solution");
		}

}

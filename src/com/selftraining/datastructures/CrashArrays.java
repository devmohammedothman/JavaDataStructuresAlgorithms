package com.selftraining.datastructures;

public class CrashArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CrashArrays localObj = new CrashArrays();
//		String result = localObj.traverseArray("Hello");
		
//		System.out.println("Test Result Traverse String : "+result);
		
		int arr1[] = {4,6,10};
		
		int arr2[] = {1,2,3,4,9};
		
		System.out.println("Test Result Sorted Array ");
		
		int sorted[] = localObj.mergeSortedArrays(arr1, arr2);
		for(int i : sorted)
			System.out.println("Item Value "+i);
		
		
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

}

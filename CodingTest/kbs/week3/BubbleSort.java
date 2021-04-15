package week3;

import java.util.*;

public class BubbleSort {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		int inputLength = input.nextInt();
		int sortCount = input.nextInt();
		
		int[] intArray = new int[inputLength];
		
		for(int i = 0 ; i < inputLength ; i++) {
			intArray[i] = input.nextInt();
		}
		
		pinBubbleSort(intArray, sortCount);
	}
	
	public static void pinBubbleSort(int[] intArray, int sortCount) {
		int tmp = 0;
		
		for(int i = 0; i < sortCount; i++) {
			for(int j = 0; j < (intArray.length-1) - i; j++) {
				if(intArray[j] > intArray[j+1]) {
					tmp = intArray[j+1];
					intArray[j+1] = intArray[j];
					intArray[j] = tmp;
				}
			}
		}
		
		printArray(intArray);
	}
	
	 public static void printArray(int[] resultArray) {
    	for(int i = 0; i < resultArray.length ; i++) {
    		System.out.print(resultArray[i]);
    		if(i != resultArray.length-1) {
    			System.out.print(" ");
    		}
    	}
   }
}

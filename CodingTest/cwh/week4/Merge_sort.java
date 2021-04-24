package week4;

import java.util.*;

public class Merge_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*	
		 * 	# Merge Sort[ 합병정렬 ]	
		 * 
		 *	"ALGORITHMS"단어를 임의의 배열에 한 단어로 저장 후 합병정렬을 사용하여 정렬하시오.
		 *
		 * 	(단, ALGORITHMS 은 입력받아도 무방함.)
		 * 	
		 */
		// 합병정렬할 단어를 입력받는다.
		Scanner scn = new Scanner(System.in);
		System.out.println("ALGORITHMS 을 입력해주세요");
		String str = scn.next();
		scn.close();
		
		char[] arrChar = str.toCharArray();
		
		for(char c : arrChar) {
			System.out.print(c);
		}
		System.out.print(" << arrChar 배열 데이터");
		System.out.println("");
		int start = 0;				// 
		int end = arrChar.length;
		
		mergeSort(arrChar, start, end-1); // 배열의 크기와 정렬해야하는 index값의 차이 때문에 end-1
		
		printFnc(arrChar); // sorting 한 단어 출력
		
		
	}
	
	public static void mergeSort(char[] arrChar, int start, int end) {
		
		if(start < end) {
			int mid = (start + end) / 2;
			mergeSort(arrChar, start, mid);			// 처음부터 중간 까지
			mergeSort(arrChar, mid+1, end);			// 중간+1 부터 마지막까지
			merge(arrChar, start, mid, end);		// 반으로 분리한 데이터는 정렬하며 merge 하는 형태로 진행.
		}
		
	}
	
	public static void merge(char[] arrChar, int start, int mid, int end) {
		char[] tmpArray = new char[arrChar.length]; // 임시 배열
		int i = start; // 첫번째 뭉텅이 시작점
		int j = mid+1; // 두번째 뭉텅이 시작점
		int k = start; // tmpArray index 시작점
		
		// 첫번째 뭉텅이와 두번째 뭉텅이 중 데이터가 남았을 때
		while(i<=mid && j<=end) {
			if(arrChar[i]<=arrChar[j]) {
				tmpArray[k++] = arrChar[i++];
			} else {
				tmpArray[k++] = arrChar[j++];
			}
		}
		
		// 두번째 뭉텅이가 먼저 입력 됐을 때
		while(i<=mid) {
			tmpArray[k++] = arrChar[i++];
		}
		
		// 첫번째 뭉텅이가 먼저 입력 됐을 때
		while(j<=end) {
			tmpArray[k++] = arrChar[j++];
		}
		
		// tmpArray로 정렬한 데이터 arrChar로 이관 
		for(int l=start; l<=end; l++) {
			arrChar[l] = tmpArray[l];
		}
		
	}
	
	public static void printFnc(char[] str) {
		for(int i=0; i<str.length; i++) {
			System.out.print(str[i]);
		}
	}

}

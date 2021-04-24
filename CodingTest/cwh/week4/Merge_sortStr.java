package week4;

import java.util.Arrays;

public class Merge_sortStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*	
		 * 	# Merge Sort[ 합병정렬 ]	
		 * 
		 *	문장 “TAKE OUT insurance oN” 을 합병정렬을 사용하여 정렬할것.
		 *
		 * 	(단, 정렬시 띄어쓰기 없는 하나의 단어 형태로 정렬할것, 또한 
		 * 	Oracle 대소문자 정렬을 기준으로 단어를 정렬할 것. >> ABCDEabcde~
		 *  문장은 복붙하여 사용하고, 해당문장은 String str의 변수값으로 저장해 놓고 진행)
		 * 
		 */
		String str = "TAKE OUt insurance oN";
		System.out.println(str + " 오늘의 문장 ");
		String banToSpace = str.replace(" ", "");
		
		char[] arrChar = banToSpace.toCharArray();
		
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
		
		// 두번째 뭉텅이가 먼저 다 입력 됐을 때
		while(i<=mid) {
			tmpArray[k++] = arrChar[i++];
		}
		
		// 첫번째 뭉텅이가 먼저 다 입력 됐을 때
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

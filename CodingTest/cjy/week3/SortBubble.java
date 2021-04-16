package week3;

import java.util.Scanner;

public class SortBubble {
	public static void main(String args[]) {
		
		System.out.println("비교할 숫자의 개수와 실행할 버블정렬 횟수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int count = scan.nextInt();
		
		int [] compareNum = new int[num]; 	// 입력한 숫자들을 가지고 있을 배열 
		
		System.out.println("비교할 숫자를 개수만큼 입력하세요 ");
		for(int i=0; i<num; i++) {
			compareNum[i] = scan.nextInt();
		}
		
		for(int k=0; k<count; k++) {
			for(int j=0; j<num-1; j++) {
				if(compareNum[j]>compareNum[j+1]) {
					int temp = compareNum[j+1];
					compareNum[j+1] = compareNum[j];
					compareNum[j]=temp;
				}
			}
		}
		
		
		for(int a=0; a<num; a++) {
			System.out.print(compareNum[a] + " ");
		}
		
	}
}

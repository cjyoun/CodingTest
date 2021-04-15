package week3;

import java.util.Scanner;

public class Sort_bubble {

	public static void main(String[] args) {
		/**
  		  *		#url 첨부 https://www.acmicpc.net/problem/11920 
		  * 
		  * 
		  * 	#문제
		  * 	버블 정렬이란, 두 인접한 원소를 검사하여 자리를 바꾸는 방식으로 길이가 N인 수열을 정렬하는 알고리즘이다. 버블 정렬은 아래와 같은 단계를 총 N번 진행하면 된다.
		  * 
		  * 	첫 번째 값과 두 번째 값을 비교하여 첫 번째 값이 더 크면 자리를 바꾼다.
		  * 	두 번째 값과 세 번째 값을 비교하여 두 번째 값이 더 크면 자리를 바꾼다.
		  * 	…
		  * 	N - 1번째 값과 N번째 값을 비교하여 N - 1번째 값이 더 크면 자리를 바꾼다.
		  * 
		  * 	세찬이는 버블 정렬의 결과는 당연히 알기에 버블 정렬의 중간 과정을 알아보려고 한다. 
		  * 	하지만 N이 매우 크므로 위와 같은 단계를 K번 하면 시간이 오래 걸린다. 세찬이를 도와 버블 정렬의 중간 과정을 구하는 프로그램을 작성하여라.
		  * 
		  * 	#입력
		  * 	첫 번째 줄에는 N과 K가 주어진다.
		  * 	두 번째 줄에는 처음 수열의 상태가 주어진다. 즉, 처음 수열을 이루는 N개의 정수가 공백을 사이로 두고 차례대로 주어진다.
		  * 
		  * 	1 ≤ N ≤ 100,000
		  * 	1 ≤ K ≤ N
		  * 	수열의 각 항은 1 이상 1,000,000,000 이하의 정수이다.
		  * 
		  * 	#출력
		  * 	위 단계를 K번 한 후 수열의 상태를 출력한다.
		  * 
		  * 	-예제입력
		  * 	4 1					23 32 15 62
		  * 	62 23 32 15			
		  * 
		  **/
		
		Scanner scn = new Scanner(System.in);
		
		int inputArr = scn.nextInt();	// 입력받을 수열의 갯수
		int repeatCnt = scn.nextInt();	// 정렬과정을 반복할 횟수
		int[] sequence = new int[inputArr];	// 입력받은 수열을 저장할 배열
		
		for(int i=0; i<inputArr; i++) {	// 입력받을 수열의 갯수만큼 반복문으로 입력받으면서 정렬할 배열에 입력한다.
			sequence[i] = scn.nextInt();
		}
		
		if( (inputArr >= 1 && inputArr <= 100000) ) {	// 조건 1 >> 1 ≤ N ≤ 100,000
			if( (repeatCnt >= 1 && repeatCnt <= inputArr) ) {	// 조건2 >> 1 ≤ K ≤ N
				
				for(int j=0; j<repeatCnt; j++) {	
					// # 뒤에서 부터 시작했을때 정렬
					/*
					for(int k=inputArr-1; k>0; k--) {
						int tmpNum;
						if( sequence[k-1] > sequence[k] ) {
							tmpNum = sequence[k];
							sequence[k] = sequence[k-1];
							sequence[k-1] = tmpNum;
						}else {
							continue;
						}
					}*/
					// # 앞에서 부터 시작했을 때 정렬
					for(int k=0; k<inputArr-1; k++) {
						int tmpNum;
						if( sequence[k] > sequence[k+1]  ) {
							tmpNum = sequence[k];
							sequence[k] = sequence[k+1];
							sequence[k+1] = tmpNum;
						}else {
							continue;
						}
					}
				}
				printFnc(sequence);
			}else {
				System.out.println("정렬과정을 반복할 횟수는 1번 이상 "+inputArr+"번 이하입니다. ");
			}
		}else {
			System.out.println("입력하신 수열의 갯수가 1개 이상 100,000개 이하의 조건에 맞지 않습니다.");
		}
	}
	
	public static void printFnc(int[] sequesce) {
		for(int i=0; i<sequesce.length; i++) {
			System.out.print(sequesce[i]+" ");
		}
	}

}

package week3;

import java.util.Scanner;

public class Sort_locationPoint {

	public static void main(String[] args) {
		/**		
 		  *     #url 첨부 : https://www.acmicpc.net/problem/11650	
 		  *     
 		  *     좌표 정렬하기
 		  *     
		  * 	문제 
		  * 	2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, 
		  * 	x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
		  * 
		  * 	입력
		  * 	첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 
		  * 	둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. 
		  * 	(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
		  * 	
		  * 	출력
		  * 	첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
		  * 	
		  * 	예제입력					예제출력
		  * 	5						1 -1
		  *		3 4						1 1
		  *		1 1						2 2
		  *		1 -1					3 3
		  *		2 2						3 4
		  *		3 3
		  *
		  *		
		  *		# 현재 풀이 방법은 버블정렬을 사용한 풀이 방법인것같음. >> 다른 정렬방식을 사용한 풀이도 해볼것. 2021.04.15 CHOIWONHYEOK
		  *
		  **/
		Scanner scn = new Scanner(System.in);
		int cnt = scn.nextInt();
		int[] inputX = new int[cnt];
		int[] inputY = new int[cnt];
		
		if(cnt > 1) {
			System.out.println("입력받을 갯수는 = " + cnt + "개");
			for(int i=0; i<cnt; i++) {
				int pointX = scn.nextInt();
				int pointY = scn.nextInt();
				
				inputX[i] = pointX;
				inputY[i] = pointY;
//				System.out.println("arrX["+i+"] = " + arrX[i]);		// 입력받은 X 저장
//				System.out.println("arrY["+i+"] = " + arrY[i]);		// 입력받은 Y 저장
			}
			scn.close();
			
			// i > arrX[i], arrY[i] 하나의 좌표로 봐야함.
			// 2중 for문으로 돌리는데 언제까지 돌려야 맞지? 어디에 있는지 알고?
			for(int j=0; j<cnt; j++) {
				int[] tmpPointX = new int[cnt];
				int[] tmpPointY = new int[cnt];
				for(int k=cnt-1; k>0; k-- ) {
					if( (inputX[k] < inputX[k-1]) && (inputY[k] < inputY[k-1]) ) {
						// X좌표 앞으로 한칸이동
						tmpPointX[k] = inputX[k];
						inputX[k] = inputX[k-1];
						inputX[k-1] = tmpPointX[k];
						// Y좌표 앞으로 한칸이동
						tmpPointY[k] = inputY[k];
						inputY[k] = inputY[k-1];
						inputY[k-1] = tmpPointY[k];
						
					}else if( (inputX[k] == inputX[k-1]) && (inputY[k] < inputY[k-1]) ) {
						// X좌표가 같고 Y좌표 n번 과 n-1번 의 데이터를 비교시 n-1번 째 데이터가 클 때
						// Y좌표 앞으로 한칸이동
						tmpPointY[k] = inputY[k];
						inputY[k] = inputY[k-1];
						inputY[k-1] = tmpPointY[k];
						// X좌표 앞으로 한칸이동
						tmpPointX[k] = inputX[k];
						inputX[k] = inputX[k-1];
						inputX[k-1] = tmpPointX[k];
					}else if( (inputX[k] == inputX[k-1]) && (inputY[k] > inputY[k-1]) ) {
						// X좌표가 같고 Y좌표 n번 과 n-1번 의 데이터를 비교시 n-1번 째 데이터가 작을 때
						continue;
					}else if( (inputX[k] < inputX[k-1]) && (inputY[k] == inputY[k-1]) ) {
						// Y좌표가 같고 X좌표 n번 과 n-1번 의 데이터를 비교시 n-1번 째 데이터가 클 때
						// X좌표 앞으로 한칸이동
						tmpPointX[k] = inputX[k];
						inputX[k] = inputX[k-1];
						inputX[k-1] = tmpPointX[k];
						// Y좌표 앞으로 한칸이동
						tmpPointY[k] = inputY[k];
						inputY[k] = inputY[k-1];
						inputY[k-1] = tmpPointY[k];
					}else if( (inputX[k] > inputX[k-1]) && (inputY[k] == inputY[k-1]) ) {
						// Y좌표가 같고 X좌표 n번 과 n-1번 의 데이터를 비교시 n-1번 째 데이터가 작을 때
						continue;
					}else {
						continue;
					}
				}
			}
			for(int l=0; l<cnt; l++) {
				System.out.println(inputX[l]+" "+inputY[l]);
			}
			
		}else {
			System.out.println("최소 2개의 좌표는 입력해야 정렬이 가능합니다.");
			scn.close();
		}
	}

}

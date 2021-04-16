package week2;

import java.util.Scanner;

//1. 입력한 좌표값이 검은색일 때만 인접한 칸수를 구함(흰색(0)일땐 패스)
//2. 검은색(1)일 경우 그칸의 주변(동서남북 대각선)에서 검은색칸만 카운트(흰색은 제외)
public class CountingCells {
	
	static String [][] miro = {
			{"1","0","0","1","1","0","0"},
			{"0","1","0","1","0","1","0"},
			{"0","1","0","0","0","0","1"},
			{"0","0","0","0","1","1","1"},
			{"1","1","0","0","0","0","0"},
			{"0","1","0","1","0","1","0"},
			{"0","0","1","0","0","0","1"}
	};
	
	static String [][] copyMiro = miro;
	static int count = 0;
	
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두 정수 입력하시오.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println(counting(a,b)+"개");
		
	}
	
	public static int counting(int x, int y) {
		
		if(x<0||x>6||y<0||y>6) {
			return 0;
			
		} else if(copyMiro[x][y]!="1") {
			return 0;
		} else {
			copyMiro[x][y] = "false";
			return 1 + counting(x-1,y) + counting(x-1,y+1) + counting(x,y+1) + counting(x+1,y+1) + counting(x+1,y)+ counting(x+1,y-1)+ counting(x,y-1)+ counting(x-1,y-1);
		}
		
		
	}
}

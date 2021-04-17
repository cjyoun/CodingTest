package week3;

import java.util.Scanner;

public class SortLocation {
	
	public static void main(String args[]) {
		
		System.out.println("비교할 점의 개수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int spotNum = scan.nextInt();
		
		int [] xSpot = new int[spotNum]; 	// x 좌표들을 가지고 있는 배열 
		int [] ySpot = new int[spotNum]; 	// y 좌표들을 가지고 있는 배열 
		
		System.out.println("비교할 점의 좌표를 개수만큼 입력하세요 ");
		for(int i=0; i<spotNum; i++) {
			xSpot[i] = scan.nextInt();
			ySpot[i] = scan.nextInt();
		}
		
		
		int xtemp, ytemp;
		for(int k=0; k<spotNum; k++) {
			for(int j=0; j<spotNum-1; j++) {
				if(ySpot[j]>ySpot[j+1]) {
					ytemp = ySpot[j+1];
					ySpot[j+1] = ySpot[j];
					ySpot[j]=ytemp;
					
					xtemp = xSpot[j+1];
					xSpot[j+1] = xSpot[j];
					xSpot[j]=xtemp;
				} else if(ySpot[j]==ySpot[j+1] && xSpot[j]>xSpot[j+1]) {
					ytemp = ySpot[j+1];
					ySpot[j+1] = ySpot[j];
					ySpot[j]=ytemp;
					
					xtemp = xSpot[j+1];
					xSpot[j+1] = xSpot[j];
					xSpot[j]=xtemp;
				}
				
			}
		}
		
		for(int a=0; a<spotNum; a++) {
			System.out.println(xSpot[a] + " " + ySpot[a]);
		}
		
		
		
	}

}

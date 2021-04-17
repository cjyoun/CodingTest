package week3;

import java.util.Scanner;

public class SortLocationBubble {
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
					compareNum[j] = temp;
				}			
			}
		}
		
		int [] xSpot = new int[num/2]; 	// 입력한 숫자들을 가지고 있을 배열 
		int [] ySpot = new int[num/2]; 	// 입력한 숫자들을 가지고 있을 배열 
		int index1 = 0;
		int index2 = 0;
		for(int p=0; p<num; p++) {
			if(p%2==0) {
				xSpot[index1]=compareNum[p];
				index1++;
			} else {
				ySpot[index2]=compareNum[p];
				index2++;
			}
		}
		
		int xtemp, ytemp;
		for(int k=0; k<num/2; k++) {
			for(int j=0; j<(num/2)-1; j++) {
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
		
		for(int a=0; a<num/2; a++) {
			System.out.print(xSpot[a] + " " + ySpot[a] +" ");
		}
		
	}
}

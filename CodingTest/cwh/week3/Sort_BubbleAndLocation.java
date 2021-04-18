package week3;

import java.util.Scanner;

public class Sort_BubbleAndLocation {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
        int inputArr = scn.nextInt();   // 입력받을 수열의 갯수
        int repeatCnt = scn.nextInt();   // 정렬과정을 반복할 횟수
        int[] sequence = new int[inputArr];   // 입력받은 수열을 저장할 배열

        if( inputArr % 2 == 0 ){
            for(int i=0; i<inputArr; i++) {   // 입력받을 수열의 갯수만큼 반복문으로 입력받으면서 정렬할 배열에 입력한다.
                sequence[i] = scn.nextInt();
            }

            for(int j=0; j<repeatCnt; j++) {  
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
        }else{
            System.out.println("입력하신 수열의 갯수가 짝수 여야 합니다.");
        }
        

        int[] inputX = new int[inputArr];  // how to init arrary length?
        int[] inputY = new int[inputArr];
        
        for(int k=0; k<sequence.length; k++){
            if( k==0 ){
                inputX[k] = sequence[k];
            }else if( (k > 0) && (k % 2 != 0) ){
                inputY[k-1] = sequence[k];
            }else if( (k > 0) && (k % 2 ==0)){
                inputX[k] = sequence[k];
            }
        }
        /*
        for(int l=0; l<inputArr; l++) {
            System.out.println(inputX[l]+" "+inputY[l]);
         }*/
        for(int j=0; j<inputArr; j++) {
            int[] tmpPointX = new int[inputArr];
            int[] tmpPointY = new int[inputArr];
            for(int k=inputArr-1; k>0; k-- ) {
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
        
        printFnc(inputX, inputY, inputArr);
	}
	
	public static void printFnc(int[] inputX, int[] inputY, int inputArr) {
		for(int l=2; l<inputArr; l++) {
        	System.out.println(inputX[l]+" "+inputY[l]);
        }
	}

}

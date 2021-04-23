package week4;

//문제1. "ALGORITHMS"단어를 임의의 배열에 한 단어로 저장 후 합병정렬을 사용하여 정렬하시오.
//(단, ALGORITHMS 은 입력받아도 무방함.)

public class MergeSort {
	
	public static void main(String args[]) {
		
		String [] letter = {"ALGORITHMS"};
		// ABCDEFGHIJKLNMOPQRSTUWXYZ
		
		int [] letter_first = new int[letter[0].length()];
		for(int i=0; i<letter[0].length(); i++) {
			letter_first[i] = (int) letter[0].substring(i,i+1).charAt(0);		// int로 형변환하여 substring으로 한글자씩 담음 
			System.out.print(letter_first[i]+ " . " );
		}
		System.out.println("");
		mergeSort(letter_first, 0, letter_first.length-1);	// end지점까지 검사하기 때문에 -1 해줘야함. (안그러면 ArrayBoundOutOfRange 에러 발생)
		
		for(int i=0; i<letter_first.length; i++) {
			System.out.print((char)letter_first[i]);	// 아스키 코드로 형변환하여 글자 출력 
		}
		
	}
	
	
	public static void mergeSort(int data[], int first, int last) {
		if(first<last) {
			int middle = (first+last)/2;
			System.out.println("middle - " + middle + " / first - " + first + " / last - " + last);
			mergeSort(data, first, middle);		// 배열을 나누었을 때 앞부분 
			mergeSort(data, middle+1, last);	// 배열을 나누었을 때 뒷부분 
			merge(data, first, middle, last);	// 숫자 정렬하기 
		}
	

	}

	public static void merge(int data[], int first, int middle, int last) {
		int i=first;
		int j=middle+1;
		int k=first;
		
		int [] temp = new int[data.length];
		
		// 첫번째 배열과 두번째 배열이 아직 남아 있을 때 
		while(i<=middle && j<=last) {
			if(data[i]<=data[j]) {
				temp[k++] = data[i++];
			} else {
				temp[k++] = data[j++];
			}
		}
		
		// 위의 while문을 통해 아래 while문 중 1개만 실행됨.
		//-------------------------------------------
		// 첫번째 배열이 남아있을 때 (두번째 배열은 모두 소진)
		while(i<=middle) {
			temp[k++] = data[i++];
		}
		
		// 두번째 배열이 남아있을 때 (첫번째 배열은 모두 소진)
		while(j<=last) {
			temp[k++] = data[j++];
		}
		//-------------------------------------------
		
		// temp배열에 담아 놓은 값들을 원래 배열인 data배열에 이동 
		for(int index=first; index<=last; index++) {
			data[index] = temp[index];
		}

		
	}

}




//public class MergeSort {
//	
//	public static void main(String args[]) {
//		
//		String [] letter = {"ALGORITHMS"};
//		// ABCDEFGHIJKLNMOPQRSTUWXYZ
//		
//		System.out.println(letter[0].length());
//		
//		String first = letter[0].substring(0,(letter[0].length()/2)); // 절반으로 나눈 글자를 담을 배열1
//		
//		String middle = letter[0].substring((letter[0].length()/2));  // 절반으로 나눈 글자를 담을 배열2
//		
//		System.out.println(first + " / " + middle);
//		
//		int [] letter_first = new int[first.length()];		// 비교를 위해 아스키코드를 담을 배열1
//		int [] letter_middle = new int[middle.length()];	// 비교를 위해 아스키코드를 담을 배열2
//		
//		for(int i=0; i<first.length(); i++) {
//			letter_first[i] = (int) first.substring(i,i+1).charAt(0);		// substring으로 한글자씩 담음 
//			letter_middle[i] = (int) middle.substring(i,i+1).charAt(0);
//			System.out.println(letter_first[i]+ " . " + letter_middle[i]);
//		}
//
//		// 아스키코드를 담은 배열들의 값을 비교해서 각각 정렬시키기 
//		int xtemp, ytemp;
//		for(int k=0; k<first.length(); k++) {		
//			for(int j=0; j<first.length()-1; j++) {
//				// 첫번째 배열 정렬 (버블정렬)
//				if(letter_first[j]>letter_first[j+1]) {
//					ytemp = letter_first[j+1];
//					letter_first[j+1] = letter_first[j];
//					letter_first[j]=ytemp;
//					
//				}
//				// 두번째 배열 정렬 (버블정렬)
//				if(letter_middle[j]>letter_middle[j+1]) {
//					xtemp = letter_middle[j+1];
//					letter_middle[j+1] = letter_middle[j];
//					letter_middle[j]=xtemp;
//				}
//				
//			}
//			
//		}
//		
//		for(int i=0; i<first.length(); i++) {
//			System.out.println((char)letter_first[i]+ " / " + (char)letter_middle[i]);
//		}
//		
//		int num1 = 0;	// 첫번째 배열의 인덱스 
//		int num2 = 0;	// 두번째 배열의 인덱스 
//		int num3 = 0;	// 글자를 담을 배열의 인덱스 
//		char [] changeLetter = new char[letter[0].length()];	// 최종 정렬된 글자를 담을 배열 
//		
//		// 배열의 크기가 10이 될때까지 반복 
//		while(num3!=10) {
//			// 첫번째 배열의 크기를 넘어 정렬을 하는 글자를 모두 소진 하였을 때 남은 두번째 배열의 글자들을 이어붙이기 
//			if(num1==(letter[0].length()/2)) {
//				for(int i=num3; num3<letter[0].length(); i++) {
//					changeLetter[i] = (char) letter_middle[num2];
//					num2++;
//					num3++;
//					System.out.println("num2 - " + num2 + " / num3 - " + num3);
//				}
//				break;
//			} else if(num2==(letter[0].length()/2)){ // 두번째 배열의 크기를 넘어 정렬을 하는 글자를 모두 소진 하였을 때 남은 첫번째 배열의 글자들을 이어붙이기 
//				for(int i=num3; num3<letter[0].length(); num3++) {
//					changeLetter[i] = (char) letter_middle[num1];
//					num1++;
//					num3++;
//					System.out.println("num1 - " + num1 + " / num3 - " + num3);
//				}
//				break;
//			} else {
//				// 첫번째 배열의 숫자가 두번째 배열의 숫자보다 클 때 
//				if(letter_first[num1]>letter_middle[num2]) {
//					changeLetter[num3] = (char) letter_middle[num2];
//					num2++;	
//					num3++;
//					System.out.println("num2 - " + num2 + " / num3 - " + num3);
//				} else {
//					changeLetter[num3] = (char) letter_first[num1];
//					num1++;
//					num3++;
//					System.out.println("num1 - " + num1 + " / num3 - " + num3);
//				}
//			}
//		}
//		
//		for(int i=0; i<changeLetter.length; i++) {
//			System.out.print(changeLetter[i]);
//		}
//		
//	}
//
//}

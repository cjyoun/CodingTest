package week4;

//문제2. 문장 “TAKE OUT insurance oN” 을 합병정렬을 사용하여 정렬할것.
//(단, 정렬시 띄어쓰기 없는 하나의 단어 형태로 정렬할것, 또한 Oracle 대소문자 정렬을 기준으로 단어를 정렬할 것.
//문장은 복붙하여 사용하고, 해당문장은 String str의 변수값으로 저장해 놓고 진행)

public class MergeSortLetter {
public static void main(String args[]) {
		
		String letter = "TAKE OUT insurance oN";
		// ABCDEFGHIJKLNMOPQRSTUWXYZabcdefghijklnmopqrstuwxyz
		int count = 0; // 띄어쓰기 개수 
		
		for(int i=0; i<letter.length(); i++) {
			if(letter.substring(i,i+1).equals(" ")) { 	// 띄어쓰기 개수 구하기 
				count++;
			} else {
			}
		}
		System.out.println("count - " + count);
		
		int [] letter_first = new int[letter.length()-count]; // 띄어쓰기 개수 만큼의 크기 제외 
		int j = 0;	// 띄어쓰기가 해당하는 인덱스 번호가 존재하는 것을 막기 위해 letter_first 배열의 인덱스 번호는 따로 선언하여 증가시킴 
		for(int i=0; i<letter.length(); i++) {
			if(letter.substring(i,i+1).equals(" ")) { 	// 띄어쓰기는 제외시키기 
				
			} else {
				letter_first[j] = (int) letter.substring(i,i+1).charAt(0);	// int로 형변환(아스키코드로 비교)하여 substring으로 한글자씩 담음 
				System.out.print(letter_first[j]+ " . " );
				j++;
				
			}

		}
		System.out.println("");
		mergeSort(letter_first, 0, letter_first.length-1);	// end지점까지 검사하기 때문에 -1 해줘야함. (안그러면 ArrayBoundOutOfRange 에러 발생)
		
		for(int i=0; i<letter_first.length; i++) {
			System.out.print((char)letter_first[i]);	// char로 형변환하여 글자 출력 
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
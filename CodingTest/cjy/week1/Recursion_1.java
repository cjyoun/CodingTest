package week1;

// �Լ� recursion�� ����Ͽ� 100���� ���� �� Ȧ���� ���� ���Ͻÿ�.
public class Recursion_1 {
	
	public static void main(String [] args) {
		int sum = 0;		// �հ�
		int num = 1;		// ���ۼ���
		getOdd(num,sum);	// Recursion �Լ�
	}
	
	public static void getOdd(int num, int sum) {
		
		if(num>100) {
			System.out.println("Ȧ���� �� : " + sum);
		} else {
			// Ȧ�� �� �� 
			if((num%2)==1) {
				sum = sum + num;
				System.out.println("num - "+ num +" / sum - " + sum);
				num++;
				getOdd(num,sum);	// Recursion �Լ�
			} else {	// ¦�� �� ��
				num++;
				getOdd(num,sum);	// Recursion �Լ�
			}
		}
				
	}
}

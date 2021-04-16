package week1;

// �̷θ� Ż�� �ϱ� ���� �������ϴ� �ּ��� ĭ �� ���ϱ�.
// 0�� �ո� ���̰� 1�� ���� ��
// [0,0]�� ���� [4,4]�� ����
public class Miro{
	
	static String [][] miro = {
			{"0","0","0","0","0"},
			{"0","1","0","1","1"},
			{"0","0","1","1","1"},
			{"1","0","0","0","0"},
			{"0","0","1","1","0"}
	};
//	static String [][] miro = {
//			{"0","1","0","0","0"},
//			{"0","1","0","1","0"},
//			{"0","0","0","1","0"},
//			{"0","1","1","1","0"},
//			{"0","0","0","0","0"}
//	};
	static String [][] fakeMiro = miro;	// ������ ���� ǥ���ϱ� ���� �ֵ��� �̷� 
	static int count = 0;	// �̵��� ĭ �� 
	static int i = 0;		// ���� 
	static int j = 0;		// ���� 
	static String preDirection = "";	// ������ �����ߴ� ���� 
	
	public static void main(String args[]) {
		getCount();
		
	}
	
	public static void getCount() {

		if(i==4&&j==4) {
			System.out.println("������ �ּ� ĭ�� = "+count);
		}else {
			switch(preDirection) {
				case "" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";	// ���� ��ġ�� ������ ���̶�� ǥ�� 
						j++;
						check(fakeMiro[i][j]);	// �������� ������ ���� �����丮 üũ.(�����Դ� ������ �ƴ���)
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j+1]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else {
						System.out.println("�̷�����? ") ;
					}
					break;
							
				case "right" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						miro[i][j+1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else {
						System.out.println("�̷�����? right") ;
					}
					break;
							
				case "down" : 	
					if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						miro[i+1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else {
						System.out.println("�̷�����? down") ;
						
					}
					break;
							
				case "left" :
					if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						miro[i][j-1]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else {
						System.out.println("�̷�����? left") ;
					}
					break;
							
				case "up" : 	
					if(j-1!=-1 && miro[i][j-1]!="1") {
						preDirection = "left";
						fakeMiro[i][j] = "NoCount";
						j--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(j+1!=5 && miro[i][j+1]!="1") {
						preDirection = "right";
						fakeMiro[i][j] = "NoCount";
						j++;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i-1!=-1 && miro[i-1][j]!="1") {
						preDirection = "up";
						fakeMiro[i][j] = "NoCount";
						i--;
						check(fakeMiro[i][j]);
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else if(i+1!=5 && miro[i+1][j]!="1") {
						preDirection = "down";
						fakeMiro[i][j] = "NoCount";
						i++;
						check(fakeMiro[i][j]);
						miro[i-1][j]="1";
						System.out.println(preDirection + " - " + "i : "+i+" j : "+j + " / " +count) ;
						getCount();
					} else {
						System.out.println("�̷�����? up") ;
					}
					break;
							
			}
			
				
		}
		
	}
	
	public static void check(String road) {
		if(road=="NoCount") {
			count--;
		}else {

			count++;

		}
	}
	
	

}
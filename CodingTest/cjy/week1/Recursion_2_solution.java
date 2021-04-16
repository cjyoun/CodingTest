package week1;

public class Recursion_2_solution {
	private static int n=5;
	private static int [][] maze = {
			{0,0,0,0,0},
			{0,1,0,1,1},
			{0,0,1,1,1},
			{1,0,0,0,0},
			{0,0,1,1,0}
	};
//	static int [][] maze = {
//	{0,1,0,0,0},
//	{0,1,0,1,0},
//	{0,0,0,1,0},
//	{0,1,1,1,0},
//	{0,0,0,0,0}
//};
	
	private static final int PATHWAY_COLOUR = 0;	// �����ٴҼ� �ִ� ĭ 
	private static final int WALL_COLOUR = 1;		// �� 
	private static final int BLOCKED_COLOUR = 2;	// �̹� �湮�غ��� �ⱸ���� �̾��� ���� �ƴ� 
	private static final int PATH_COLOUR = 3;		// ���� �������� �ⱸ���� ���� ������� �ƴ����� �� 
	private static int count = 0;
	
	public static void main(String [] args) {

		findMazePath(0,0);	// 0,0���� ���� 
		System.out.println("�ּ� ��� : " + count);
	}
	
	public static boolean findMazePath(int x, int y) {
		
		// x y�� �̷� ���� �ǹ��� �� false ���� 
		if(x<0 || y<0 || x>=n || y>=n ) {
			System.out.println("1 x : "+x+ " y : " + y);
			return false;
		} else if( maze[x][y] != PATHWAY_COLOUR ) { // �ѹ��̶� �����ų� ���̸� false ���� 
			System.out.println("2 x : "+x+ " y : " + y);
			return false;
		} else if(x==n-1 && y==n-1) {	// �ⱸ��� �ǹ� 
			maze[x][y] = PATH_COLOUR;
			System.out.println("3 x : "+x+ " y : " + y);
			return true;
		} else {
			maze[x][y] = PATH_COLOUR; // ��ġ�� �湮���� (�� ��ġ�� Ȯ���� �ƴ����� ��)
			// ���� ��ġ�� ������ 4���� ��ǥ�� �ѷ���(����,������,�Ʒ���,���� ������ ���캽)
			// �ִ� 4���� recursion �� �Ǵ� �κ���.
			if( findMazePath(x-1,y) || findMazePath(x,y+1) || findMazePath(x+1,y) || findMazePath(x,y-1) ) {
				count++;
				System.out.println("4 x : "+x+ " y : " + y);
				return true;
			}
			maze[x][y] = BLOCKED_COLOUR; // �� ��ġ���� � �������� ������ �ⱸ���� ���� ��찡 ���� (�����±��� ���ư�����)
			System.out.println("5 x : "+x+ " y : " + y);
			return false;
		}
		
		
	}
	
}
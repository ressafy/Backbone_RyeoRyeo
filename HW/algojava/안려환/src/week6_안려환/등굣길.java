package week6_안려환;

public class 등굣길 {

	static int[][] arr;
	static int[][] puds;
	public static void main(String[] args) {
		int width = 4;
		int height = 3;
		int[][] pud = new int[][] {{2,2},{1,2}};
		
		arr = new int[height][width];
		puds = new int[height][width];
		
		arr[0][0] = 1;
		
		for(int i=0; i<pud.length; i++) {
			int[] temp = pud[i];
			puds[temp[1]-1][temp[0]-1] = 1;
		}
		int answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(i==0 && j==0) {
					continue;
				}
				
				if(puds[i][j] == 1	) {
					arr[i][j] = 0;
				}else {
					if(i==0) {
						arr[i][j] = arr[i][j-1];
					}else if(j==0) {
						arr[i][j] = arr[i-1][j];
					}else {
						arr[i][j] = (arr[i-1][j] + arr[i][j-1])%1000000007;
					}
				}
			}
		}
		
		answer = arr[arr.length-1][arr[0].length-1];
		System.out.println(answer);
		
	}

}

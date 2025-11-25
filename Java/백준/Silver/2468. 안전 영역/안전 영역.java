import java.io.*;
import java.util.*;


class Main {
	
	static int N;
	static int[][] area;
	static int maxHeight = 0;
	static int minHeight = Integer.MAX_VALUE;
	static boolean[][] visited;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		area = new int[N][N]; 
		for(int i = 0; i< N; i++) {
			String[] tempLine = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				int tempInt = Integer.parseInt(tempLine[j]);
				area[i][j] = tempInt;
				
				if (tempInt > maxHeight) {
					maxHeight = tempInt;
				}
				if (tempInt < minHeight) {
					minHeight = tempInt;
				}
			}
		}
		
		int result = 0;
		for(int h = minHeight ; h <= maxHeight; h++) {
			visited = new boolean[N][N];
			
			// 물에 잠기는 지역 표시
			flood(h);

			// 안전 영역 세기
			int count = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {					
					if ( !visited[i][j] ) {
						dfs(i, j);
						count++;
					}
				}
			}
			
			// 안전영역 개수 갱신
			if (result < count) {
				result = count;
			}
		}	
		
		System.out.println(result);
		
	}
	
	// 물에 잠기는 지역 표시
	static void flood(int h) {
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(area[i][j] < h) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	// 안전영역 counting
	static void dfs(int x, int y) {
		
		int [][] direct = new int[][] {{0, 0, 1, -1}, {1, -1, 0, 0}};
		
		for(int i = 0; i < 4; i ++) {
			int dx = x + direct[0][i];
			int dy = y + direct[1][i];
			
			if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
				continue;
			}
			
			if ( visited[dx][dy] ) {
				continue;
			}
			
			visited[dx][dy] = true;
			dfs(dx, dy);
		}
		
		
	}
		
}
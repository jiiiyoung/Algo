import java.util.*;
import java.io.*;

class Main{
	
	static boolean[][] visited;
	static int[][] fields;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T ; t++) {
			
			// 값 입력
			String[] size = br.readLine().split(" ");
			
			M = Integer.parseInt(size[0]); // 가로
			N = Integer.parseInt(size[1]); // 세로
			int K = Integer.parseInt(size[2]);
			
			visited = new boolean[N][M];
			fields = new int[N][M];
			
			for(int k = 0; k < K; k++) {
				String[] temp = br.readLine().split(" ");
				
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				
				fields[y][x] = 1;
			}
			
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					// 배추가 있고, 방문하지 않은 경우 (지렁이가 필요한 영역)
					if(fields[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
						
			System.out.println(count);
		}
		
	}
	
	static void dfs(int y, int x) {
		int[][] direct = new int[][] { {0, 0, 1, -1}, {1, -1, 0, 0} };
		
		for(int i = 0; i < 4; i++) {
			int dy = y + direct[0][i];
			int dx = x + direct[1][i];
			
			if(dy < 0 || dy >= N || dx < 0 || dx >= M) {
				continue;
			}
			
			if ( visited[dy][dx] || fields[dy][dx] == 0 ) { 
				continue;
			}
			visited[dy][dx] = true; // 방문 표시, 표시한 영역은 지렁이가 갈 수 있는 곳
			dfs(dy, dx);
			
		}
	}
	
}
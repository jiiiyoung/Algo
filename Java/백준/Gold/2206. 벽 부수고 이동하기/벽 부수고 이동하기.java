import java.util.*;
import java.io.*;

class Main{
	
	static int[][] map;
	static boolean[][][] visited;
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// bfs로 탐색. 탐색할 때, x, y, isBreak(1인경우)을 들고다녀야 함.	
		// visited[][][] 3차원 배열로 isBreak를 넣어야한다.
		
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for(int i = 0; i < N; i++) {
			String[] point = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(point[j]);
			}
		}
		
		visited[0][0][0] = true;
		
		// x, y, isBreak, level
		q.add(new int[] {0, 0, 0, 1});
		bfs();		
		
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
		
	}
	
	static void bfs() {
		int[] directX = new int[] {0, 0, -1, 1};
		int[] directY = new int[] {1, -1, 0, 0};
				
		while( !q.isEmpty() ) {
			
			int[] current = q.poll();
			int pX = current[0];
			int pY = current[1];			
			int isBreak = current[2];
			int level = current[3];
			
			if (pX == N - 1&& pY == M - 1) {
				if(result > level) {
					result = level;
				}
			}
			
			
			for(int i = 0; i < 4; i++) {
				int dx = pX + directX[i];
				int dy = pY + directY[i];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= M ) {
					continue;
				}
				
				if(visited[dx][dy][isBreak]) {
					continue;
				}
				
				if (map[dx][dy] == 1 && isBreak == 0) {
					visited[dx][dy][1] = true;
					q.add(new int[] {dx, dy, 1, level + 1});				
				}
				
				if(map[dx][dy] == 0) {
					visited[dx][dy][isBreak] = true;
					q.add(new int[] {dx, dy, isBreak, level+1});
				}

			}
			
		}
		
		
	};


}
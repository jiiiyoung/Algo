import java.util.*;
import java.io.*;

class Main {
	static int N, M, H;
	static int[][][] tomatos;
	static boolean[][][] visited;
	static Queue<int[]> q = new LinkedList();
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		
		M = Integer.parseInt(size[0]);
		N = Integer.parseInt(size[1]);
		H = Integer.parseInt(size[2]);
		
		tomatos = new int[H][N][M];
		visited = new boolean[H][N][M];
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				String[] temp = br.readLine().split(" ");
				for(int m = 0; m < M; m++) {
					int tomato = Integer.parseInt(temp[m]); 
					
					//값 입력
					tomatos[h][n][m] = tomato;
					
					// 익은 토마토 구분 및 방문표시
					if(tomato == 1) {
						q.add(new int[] {h, n, m, 0});
						visited[h][n][m] = true;
					}
				}				
			}
		}
		
		
		// 토마토 익히기
		int result = bfs();
		
		
		// 안익은 토마토 있는지 확인
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(tomatos[h][n][m] == 0) {
						result = -1;
						break;
					}
				}	
				if(result == -1) break;
			}
			if(result == -1) break;
		}
		
		System.out.println(result);
		
		
	}
	
	static int bfs() {
		int[][] direct = new int[][] {{1, -1, 0, 0, 0, 0}, {0, 0, 1, -1, 0, 0}, {0, 0, 0, 0, 1, -1}};
		
		int result = 0;
		while(!q.isEmpty()) {
			
			int[] current = q.poll();
			int day = current[3];
			
			// 며칠 지났는지 확인
			if (day > result) {
				result = day;
			}
			
			for(int i = 0; i < 6; i++) {
				int dh = current[0] + direct[0][i];
				int dn = current[1] + direct[1][i];
				int dm = current[2] + direct[2][i];
				
				if (dh < 0 || dh >= H || dn < 0 || dn >= N || dm < 0 || dm >= M) {
					continue;
				}
				
				if(visited[dh][dn][dm] ) {
					continue;
				}
				
				if(tomatos[dh][dn][dm] == -1) {
					continue;
				}
				
				tomatos[dh][dn][dm] = 1;
				visited[dh][dn][dm] = true;
				q.add(new int[] {dh, dn, dm, day + 1} );
			}
		}
		
		return result;
	}
}
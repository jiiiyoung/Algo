import java.io.*;
import java.util.*;

class Main {
	
	static int N, M;
	static boolean[][] island, visited;	
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			String[] size = br.readLine().split(" ");
			
			M = Integer.parseInt(size[0]);
			N = Integer.parseInt(size[1]);
			
			if(N == 0 && M == 0) { // 입력 종료
				break;
			}
			
			island = new boolean[N][M];
			visited = new boolean[N][M];			
			for(int i = 0; i < N; i++) {
				String[] temp = br.readLine().split(" ");
				for(int j = 0; j < M; j++) {
					if (Integer.parseInt(temp[j]) == 1) {
						island[i][j] = true;	
					}else {
						island[i][j] = false;
					}					
				}
			}
			
			// 섬 개수 세기
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(island[i][j] && !visited[i][j]) {
						count++;
						visited[i][j] = true;
						q.add(new int[]{i, j});
						bfs();
					}
				}
			}
			
			// 정답 출력
			System.out.println(count);
		}
	}
	
	static void bfs() {
		
		int[][] direct = new int[][] {{0, 0, 1, -1, 1, 1, -1, -1}, {1, -1, 0, 0, 1, -1, 1, -1}};
		
		while(!q.isEmpty()) {
			
			int[] point = q.poll();
			
			for(int i = 0; i < 8; i++) {
				
				int pX = direct[0][i] + point[0];
				int pY = direct[1][i] + point[1]; 
				
				if (pX < 0 || pX >= N || pY < 0 || pY >= M) { // 범위 제외
					continue;
				}
				
				if(visited[pX][pY]) { // 방문 확인
					continue;
				}
				
				if (island[pX][pY]) { // 같은 섬인 경우 다음 탐색
					q.add(new int[] {pX, pY});
				}
				visited[pX][pY] = true;				
				
			}
			
		}
		
		
	}
}
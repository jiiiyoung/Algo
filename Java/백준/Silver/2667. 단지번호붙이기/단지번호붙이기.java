import java.io.*;
import java.util.*;

class Main{

	static int[][] apt;
	static boolean[][] visited;
	static Queue<int[]> queue = new LinkedList<>();	
	static int N;
	static List<Integer> results = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		apt = new int[N][N]; 
		visited = new boolean[N][N];
		 
		for(int i = 0; i < N; i++) {
			String[] homes = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				apt[i][j] = Integer.parseInt(homes[j]);
			} 
		}
		
		// bfs를 이용해 갯수 세기
		for(int i = N-1; i >= 0 ; i--) {
			for(int j = 0; j < N; j++) {
				if(apt[i][j] == 1 && !visited[i][j]) { // 1이면서 방문하지 않은 곳 갯수 세기
					visited[i][j] = true;
					queue.add(new int[] {i, j});
					bfs();
				}				
			}
		}
		// 오름차순 정렬
		results.sort((o1, o2) -> o1 - o2);
		
		// 정답 출력
		System.out.println(results.size());
		for(int i = 0; i < results.size(); i++) {
			System.out.println(results.get(i));
		}

	}
	
	static void bfs() {
		int[][] direct = new int[][] {{0, 0, 1, -1}, {1, -1, 0, 0}};
		
		int cnt = 1; // 들어올 때 이미 가지고 있음.

		while(!queue.isEmpty()) {
			
			int[] current = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				
				int dx = current[0] + direct[0][i];
				int dy = current[1] + direct[1][i];
				
				if(dx < 0 || dx >= N || dy < 0 || dy >= N) {
					continue;
				}
				
				if(!visited[dx][dy] && apt[dx][dy] == 1) {
					visited[dx][dy] = true;
					queue.add(new int[] {dx, dy});
					cnt++;
				}
			
			}
			
		}
		
		results.add(cnt);
		
	}
}
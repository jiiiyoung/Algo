import java.util.*;
import java.io.*;

public class Main{
	
	static int N;
	static int M;
	static int[][] graph;
	static Queue<int[]> queue = new LinkedList<>();
	static int[][] direct = new int[][] {{1, -1, 0, 0}, {0, 0, 1, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] cond = br.readLine().split(" ");
		N = Integer.parseInt(cond[0]);
		M = Integer.parseInt(cond[1]);
		int S = Integer.parseInt(cond[2]);
		
		graph = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for(int j = 0; j< M; j++) {
				if(line[j].equals("O")) {
					graph[i][j] = 2;
				}
			}
		}
		
		// 초기상태 = 1초이기 때문에 1부터 시작.
		for(int s = 1; s < S; s++) {
			visited = new boolean[N][M]; // 방문배열 초기화
				
			bfs();
		}
		
		// 결과 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				if( graph[i][j] > 0) {
					System.out.print("O");
				}else {
					System.out.print(".");
				}
			}
			System.out.println("");
		}
	}
	
	static void bfs() {		
		
		// 0이면 3을 넣고 그 외에는 -1을 해준다.
		// -1을 했을 경우 0이 되면 주변것들을 터치기 위해 queue에 넣는다.
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				graph[i][j] -= 1;
				if (graph[i][j] == 0) {
					queue.add(new int[] {i, j});
				} else if( graph[i][j] < 0 ) {
					graph[i][j] = 3;
				}
			}
		}
		
		

		// queue에 입력된 것들은 상하좌우만 0으로 하고 더 들어가지 않는다.
		while( !queue.isEmpty() ) {
			int[] temp = queue.poll();
			
			int x = temp[0];
			int y = temp[1];		

			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int dx = temp[0] + direct[0][i];
				int dy = temp[1] + direct[1][i];

				if(dx >= N || dx < 0 || dy >= M || dy < 0) {
					continue;
				}
				
				
				if(visited[dx][dy]) {
					continue;
				}
				graph[dx][dy] = 0;				
							
			}
			
		}
		
	}
}
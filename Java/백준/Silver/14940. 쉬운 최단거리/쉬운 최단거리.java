
import java.util.*;
import java.io.*;

public class Main {

	static int[][] ground;
	static boolean[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputLen = br.readLine().split(" ");
		N = Integer.parseInt(inputLen[0]);
		M = Integer.parseInt(inputLen[1]);
		
		ground = new int[N][M];
		visited = new boolean[N][M];

		int startY = 0;
		int startX = 0;
		
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				int point = Integer.parseInt(line[j]);
				
				ground[i][j] = point;
				
				if (point == 2) {
					startY = i;
					startX = j;
				}
			}
		}
		
		// 시작점 초기화
		ground[startY][startX] = 0;		
		bfs(startY, startX);
		
		// 원래 갈 수 있지만 도달할 수 없는 위치 체크
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (!visited[i][j] && ground[i][j] != 0) {
					ground[i][j] = -1;
				}
			}
		}
		
		// 답 출력
		for(int[] resultArray : ground) {
			for(int resultInt : resultArray ) {
				System.out.print(resultInt + " ");
			}
			System.out.println();
		}

	}
	
	static void bfs(int startY, int startX) {
		int[][] direct = new int[][] {{0, 0, 1, -1}, {1, -1, 0, 0}};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startY, startX, 0});

		visited[startY][startX] = true;
		
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];
			int level = cur[2];
			
			ground[y][x] = level;
			for(int i = 0; i < 4; i++) {
				
				int nextY = y + direct[0][i];
				int nextX = x + direct[1][i];
				
	
				if( nextY >= N || nextY < 0 || nextX >= M || nextX < 0 ) { // 배열 범위 체크
					continue;
				}
				
				if (ground[nextY][nextX] == 0) { // 갈 수 없는 곳 넘기기
					continue;
				}
				
				if ( visited[nextY][nextX] ) { // 방문한 곳 넘기기
					continue;
				}
			
				visited[nextY][nextX] = true;
				q.add(new int[] {nextY, nextX, level + 1});
			}
		}
		
	}
}

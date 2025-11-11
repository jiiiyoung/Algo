import java.io.*;
import java.util.*;


class Main{
	static int N, M;
	static int[][] copyArea;
	static List<int[]> combination = new ArrayList<>();
	static int result = 0;
	static Queue<int[]> q = new LinkedList<>(); 
	public static void main(String[] args) throws IOException{
		/*
		 * 연구소 빈칸에서 조합 추출.
		 * 조합을 벽으로 세우고, 바이러스 퍼지도록 bfs 실행 후
		 * 0의 개수 세서 최댓값 갱신.
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] size = br.readLine().split(" ");
		N = Integer.parseInt(size[0]);
		M = Integer.parseInt(size[1]);
		
		int[][] area = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				area[i][j] = Integer.parseInt(line[j]);
				if(area[i][j] == 0) {
					combination.add(new int[] {i, j}); 
				}
			}
		}

		
		// 조합 추출: 방법은? 3중 포문
		int comLen = combination.size();
		for(int k = 0; k < comLen - 2; k++) {
			for(int l = k + 1; l < comLen - 1; l++) {
				for(int m = l + 1; m < comLen; m++) {
					int[] select1 = combination.get(k);
					int[] select2 = combination.get(l);
					int[] select3 = combination.get(m);
					
					copyArea = Arrays.stream(area)
		                     .map(int[]::clone)
		                     .toArray(int[][]::new);
					
					copyArea[select1[0]][select1[1]] = 1;
					copyArea[select2[0]][select2[1]] = 1;
					copyArea[select3[0]][select3[1]] = 1;
					
					// bfs실행
					int count = bfs();
					
					// 0의 개수 세서 최댓값 갱신					
					if (result < count) {
						result = count;
					}
					
				}
			}	
		}
		System.out.println(result);
	}
	
	static int bfs() {
		
		// 2인 경우 queue에 집어넣고, q에서 꺼내 퍼지도록.
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (copyArea[i][j] == 2) {
					q.add(new int[] {i, j});
				}
			}
		}
		
		int[][] direct = new int[][]{{0, 0, 1, -1}, {1, -1, 0, 0}};
		while( !q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			
			// 주변 바이러스
			for(int i = 0; i < 4; i++) {
				int dx = x + direct[0][i];
				int dy = y + direct[1][i];
				
				if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
					continue;
				}
				
				if(copyArea[dx][dy] == 0) {
					q.add(new int[]{dx, dy});
					copyArea[dx][dy] = 2;
				}				
			}
		}
		
		// 0의 개수 세기
		int cnt = 0;
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyArea[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
		
		
}
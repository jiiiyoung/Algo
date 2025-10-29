import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int M;
    static int[][] tomato;
    static boolean[][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {

        // 값 입력        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        M = Integer.parseInt(size[0]); // 가로
        N = Integer.parseInt(size[1]); // 세로

        tomato = new int[N][M];
        visited = new boolean[N][M];
        queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String[] rows = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(rows[j]);

                if(tomato[i][j] == 1) { // 토마토가 익은 경우 추가
                    queue.add(new int[] {i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        
        // bfs 돌려서 깊이 반환
        int result = bfs();
        
        // 익을 수 없는 토마토가 있는 경우 -1 부여
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tomato[i][j] == 0 ) {
                    result = -1;
                    break;
                }
            }
            if(result == -1) break;
        }

        // 정답 출력
        System.out.println(result);

    }

    static int bfs() {

        int[][] direct = new int[][] {{0, 0, 1, -1}, {1, -1, 0, 0}};

        int result = 0;
        while(!queue.isEmpty()) {

            int[] current = queue.poll();
            int cnt = current[2];

            // 더 깊이 들어간 경우 값 부여
            if (cnt > result) {
                result = cnt;
            }

            for(int i = 0; i < 4; i++) {
                int y = current[0] + direct[0][i];
                int x = current[1] + direct[1][i];

                if(y < 0 || y >= N || x < 0 || x>= M) {
                    continue;
                }

                // 빈 상자 or 방문 체크
                if(tomato[y][x] == -1 || visited[y][x] ) {
                    continue;
                }

                tomato[y][x] = 1;
                visited[y][x] = true;
                queue.add(new int[] {y, x, cnt + 1});

            }

        }

        return result;
    }
}
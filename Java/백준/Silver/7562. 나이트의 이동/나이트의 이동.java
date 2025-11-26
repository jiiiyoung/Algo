import java.util.*;
import java.io.*;

class Main {

    static int N;
    static boolean[][] chessboard;
    static Queue<int[]> q;
    static int[] goal;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < TC; tc ++) {
            // 체스판 초기화
            N = Integer.parseInt(br.readLine());
            chessboard = new boolean[N][N];

            q = new LinkedList<>();

            // 시작점 입력
            String[] start = br.readLine().split(" ");
            int x = Integer.parseInt(start[0]);
            int y = Integer.parseInt(start[1]);

            chessboard[x][y] = true;
            q.add(new int[]{x, y, 0});

            // 목표 입력
            String[] end = br.readLine().split(" ");
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);

            goal = new int[]{endX, endY};

            // 최소값 탐색
            int result = bfs();
            System.out.println(result);
        }


    }

    static int bfs() {

        // 갈 수 있는 곳 배열
        int[] directX = new int[] {2, 2, 1, 1, -1, -1, -2, -2};
        int[] directY = new int[] {1, -1, 2, -2, 2, -2, 1, -1 };

        int count = 0;
        while(!q.isEmpty()) {

            int[] current = q.poll();
            count = current[2];

            if (current[0] == goal[0] && current[1] == goal[1]) {
                return count;
            }

            for(int i = 0; i < 8; i++) {

                int dx = directX[i] + current[0];
                int dy = directY[i] + current[1];

                // 체스판을 벗어난 경우 넘기기
                if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                    continue;
                }

                // 이미 방문한 경우 넘기기
                if (chessboard[dx][dy]) {
                    continue;
                }

                // 방문 표시 및 다음 경로 탐색
                chessboard[dx][dy] = true;
                q.add(new int[] {dx, dy, count + 1});
            }
        }

        return count;
    }

}
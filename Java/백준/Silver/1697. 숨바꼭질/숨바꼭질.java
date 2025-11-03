import java.util.*;
import java.io.*;


class Main {

    static int N;
    static int K;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] point = br.readLine().split(" ");

        N = Integer.parseInt(point[0]);
        K = Integer.parseInt(point[1]);

        q.add(new int[]{N, 0});
        int result = bfs();
        System.out.println(result);

    }

    static int bfs() {

        while(!q.isEmpty()) {

            int[] temp = q.poll();

            int current = temp[0];
            int cnt = temp[1];

            if(current == K) {
                return cnt;
            }

            cnt++;
            for(int i = 0; i < 3; i++){
                int dx;
                if (i == 0) {
                    dx = current - 1;
                }else if(i == 1){
                    dx = current + 1;
                }else {
                    dx = current * 2;
                }

                if (dx < 0 || dx > 100000){
                    continue;
                }
                if ( visited[dx] ){
                    continue;
                }

                visited[dx] = true;
                q.add(new int[]{dx, cnt});
            }

        }

        return -1;
    }

}
import java.util.*;
import java.io.*;

class Main {

    static int N;
    static int[][] direct = new int[][] {{0, 0, 1, -1}, {1, -1, 0, 0}};

    static int RGMan; // 색약
    static int Man; // 비색약
    static boolean[][] RGvisited;
    static boolean[][] visited;
    static String[][] painting;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        painting = new String[N][N];
        for(int i = 0; i < N; i++) {
            painting[i] = br.readLine().split("");
        }

        visited = new boolean[N][N];
        RGvisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 색약
                if(!RGvisited[i][j]) {
                    dfs(i, j, painting[i][j], true);
                    RGMan++;
                }
                
                // 비색약
                if(!visited[i][j]) { 
                    dfs(i, j, painting[i][j], false);
                    Man++;
                }

            }
        }

        System.out.println(Man + " " + RGMan);
    }
    static void dfs(int x, int y, String color, boolean isRG) {

        for(int i = 0 ; i < 4; i++) {
            int dx = x + direct[0][i];
            int dy = y + direct[1][i];


            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                continue;
            }

            if ((!isRG && visited[dx][dy]) || (isRG && RGvisited[dx][dy]))  {
                continue;
            }

            boolean next = false;
            if (isRG) { // 색약
                next = color.equals(painting[dx][dy]) || (color.equals("R") && painting[dx][dy].equals("G")) || (color.equals("G") && painting[dx][dy].equals("R"));
            }else { // 비색약
                next = color.equals(painting[dx][dy]);
            }

            if(isRG && next) { // 색약 
                RGvisited[dx][dy] = true;
                dfs(dx, dy, color, isRG);
            }else if (!isRG && next) { // 비색약
                visited[dx][dy] = true;
                dfs(dx, dy, color, isRG);
            }

        }



    }
}
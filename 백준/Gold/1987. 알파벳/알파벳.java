// 동일한 알파벳 지날 수 없음 
// 말이 최대한 이동할 수 있는 거리 구하기 (시작한 칸 포함)
// 백트래킹 ! 방문 처리를 알파벳으로
// 즉, 여기서도 지날 수 있는지 확인하고 넣기. 

import java.util.*;
import java.io.*;

public class Main{
    static int R, C;
    static int[][] map;
    static int result;
    static boolean[] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[27];
        map = new int[R][C];
        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            char c;
            for(int j=0; j<C; j++){
                c = tmp.charAt(j);
                map[i][j] = c - 'A' + 1; // [암기 !!!]
            }
        }
        result = 1;
        visited[map[0][0]] = true;
        DFS(1, 0, 0);
        // result = Math.max(result,DFS(1));
        System.out.println(result);
    }
    
    static void DFS(int cnt, int x, int y){
        // 종료 조건
        if(cnt > result){
            result = cnt;
        }
        
        int nx, ny;
        for(int i=0; i<4; i++){
            nx = x+dx[i];
            ny = y+dy[i];
            if(0<=nx && nx < R && 0<=ny && ny < C && !visited[map[nx][ny]]){
                visited[map[nx][ny]] = true;
                DFS(cnt+1, nx, ny);
                visited[map[nx][ny]] = false;
            }
        }
    }
}


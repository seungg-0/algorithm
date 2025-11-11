// 알파벳 각각 한 번씩만 지나갈 수 있음 -> 알파벳으로 방문처리
import java.io.*;
import java.util.*;

public class Main{
    static int[] dx, dy;
    static int R, C;
    static int[][] map;
    static boolean[] visited;
    static int x, y;
    static int maxCount = 1;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dx = new int[] {0, 0, -1, 1};
        dy = new int[] {-1, 1, 0, 0};
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visited = new boolean[26]; // 0~16 : A~Z
        
        // int num = ch - 'A' + 1;
        
        String str = "";
        int j;
        for(int i=0; i<R; i++){
            str = br.readLine();
            j = 0;
            for(char c : str.toCharArray()){ // [암기]
                map[i][j] = c - 'A'; // A 이면 0, B이면 1, .. 
                j++;
            }
        }
        
        // System.out.println(Arrays.deepToString(map));
        // System.out.println(Arrays.toString(visited));
        // BFS가 아닌 DFS로 풀어야 함 (우우우우/하하하하 로 이동할 수 있기 때문. 이동할 수 있는 "최대"거리를 구하는 문제)
        visited[map[0][0]] = true;
        DFS(0, 0, 1);
        System.out.println(maxCount);
        
    }
    
    static void DFS(int x, int y, int count){
        maxCount = Math.max(maxCount, count); // 현재까지 최대 이동거리 
        
        for(int i=0; i<4; i++){
            int nx = x+dx[i]; // 전역변수로 선언하면 재귀간 충돌 일어남 
            int ny = y+dy[i]; // 서로 다른 재귀 호출이 같은 변수(nx, ny)를 공유하기 때문에 [중요/암기]
            if(nx>=0 && nx<R && ny>=0 && ny<C){
                if(!visited[map[nx][ny]]){
                visited[map[nx][ny]] = true;
                DFS(nx, ny, count + 1);
                visited[map[nx][ny]] = false;
                }
            }
        }
    }
}
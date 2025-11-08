// BFS 
// 1. 1년 지날 때마다 빙산 녹이고 -> (걍 그래프탐색 ?)
// 2. 덩어리 몇 개인지 확인하고 -> BFS
// 1. 2. 를 계속 반복해야 함

import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static boolean[][] visited;
    static Queue<int[]> queue;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++){ // 초기 빙하정보 저장 
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int years = 0;
        
        // 2. 덩어리 몇 개인지 확인 
        while(true){
            int islands = counting();
            if(islands>=2){
                System.out.println(years);
                break;
            }else if(islands==0){
                System.out.println(0);
                break;
            }else{
                // 1. 1년 보내고 빙산 녹이기
                int[][] temp = new int[N][M]; // 임시 맵을 만들어주면 됨
                for(int i=0; i<N; i++){
                    for(int j=0; j<M; j++){
                        // 상하좌우 확인
                        int melts = 0;
                        for(int h=0; h<4; h++){
                            int ni = i+dx[h];
                            int nj = j+dy[h];
                            if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj] == 0){
                                melts++;
                            }
                        }
                        temp[i][j] = Math.max(0, map[i][j] - melts);// 이렇게 하면 음수 안생김
                    }
                }
                years++;
                map = temp;
                // System.out.println(Arrays.deepToString(map)); // 이중배열 디버깅 방법 봐두기
            }
        }
    }
    
    static void BFS(){
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(!visited[nx][ny] && nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny]>0){
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        return;
    }
    
    static int counting(){
        int cnt = 0;
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(map[i][j]>0){
                        queue = new LinkedList<>();
                        queue.offer(new int[] {i, j});
                        BFS();
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }   
}

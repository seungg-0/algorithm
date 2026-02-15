import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int year = 0;
    static int[][] map;
    static int island = 0;
    static int x, y;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        
        for(int i=0; i<x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<y; j++){
                // 초기 빙하 정보 입력 받기
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(true){
            island = counting(map);
            if(island>=2){ // 두 덩어리 이상으로 분리
                System.out.println(year);
                break;
            } else if (island==0){
                System.out.println(0);
                break;
            } else{ // 1년 지나고 빙하 녹이기
                int[][] nmap = new int[x][y]; // 임시 맵을 만들어주면 됨 [중요]
                // int[][] nmap = map; // 이렇게 하면 안됨 ! 참조 공유가 됨
                int nx, ny;
                for(int i=0; i<x; i++){
                    for(int j=0; j<y; j++){
                        if(map[i][j]!=0){ // 0 아니면 녹일 대상
                            int num = 0;
                            for(int ii=0; ii<4; ii++){
                                nx = i + dx[ii];
                                ny = j + dy[ii];
                                if(0<=nx && nx<x && 0<=ny && ny<y && map[nx][ny]==0){
                                    num++;
                                }
                            }
                            nmap[i][j] = Math.max(0, map[i][j]-num); // 빙하 녹이기
                        }
                    }
                }
                year++;
                map = nmap;
            }
        }
        
    }
    
    // 덩어리 세기
    static int counting(int[][] graph){
        boolean[][] visited = new boolean[x][y];
        int cnt = 0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(graph[i][j]!=0 && !visited[i][j]){
                    cnt++;
                    visited[i][j] = true;
                    BFS(graph, i, j, visited);
                }
            }
        }
        return cnt;
    }
    
    static void BFS(int[][] graph, int tx, int ty, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {tx, ty});
        int nx, ny, xx, yy;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            xx = tmp[0];
            yy = tmp[1];
            for(int i=0; i<4; i++){
                nx = xx + dx[i];
                ny = yy + dy[i];
                if(0<=nx && nx < x && 0 <= ny && ny<y && !visited[nx][ny] && graph[nx][ny]!=0){
                    queue.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
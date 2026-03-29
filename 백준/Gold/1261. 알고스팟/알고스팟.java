// BFS 이용하기 (0-1 BFS)
// BFS를 사용할 것이냐, 다익스트라를 사용할 것이냐는 다음과 같이 분리하면 된다.
// 1. 가중치 없음 > BFS, 2. 가중치 0 또는 1 > 0-1BFS, 3. 가중치 여러 값 > 다익스트라
// 이 문제의 경우 2번 유형
// Deque<int[]> dq = new ArrayDeque<>();
// 비용이 0이면 앞에, 비용이 1이면 뒤에 넣기 
// dq.pollFirst();, dq.addFirst(next);, dq.addLast(next);

import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer = 0;
    static int[][] dist;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j)-'0'; // [입력형식 암기]
            }
        }
        
        BFS(0, 0);
        System.out.println(dist[N-1][M-1]);
    }
    
    // 0-1 BFS는 한 번 방문했다고 끝이 아니라, 더 작은 비용이면 다시 갱신해야 함
    // 따라서 visited 대신 distance 비교가 필요함
    public static void BFS(int x, int y){
        dist = new int[N][M]; // 0-1 BFS에서는 거리 맵이 따로 있어야 함
        for(int [] d : dist) Arrays.fill(d, Integer.MAX_VALUE); // [형식 암기]
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] {x, y}); // 출발지 저장
        dist[0][0] = 0;
        while(!dq.isEmpty()){
            int[] xy = dq.pollFirst();

            for(int i=0; i<4; i++){
                int nx = xy[0]+dx[i];
                int ny = xy[1]+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    int cost = map[nx][ny];
                    if(dist[nx][ny] > dist[xy[0]][xy[1]]+cost){
                        dist[nx][ny] = dist[xy[0]][xy[1]]+cost;
                        
                        if(cost==0){
                            dq.addFirst(new int[] {nx, ny});// 우선적으로 넣기
                        }else{
                            dq.addLast(new int[] {nx, ny}); // 후순위로 넣기
                        }
                    }
                }
            }
        }
    }
}
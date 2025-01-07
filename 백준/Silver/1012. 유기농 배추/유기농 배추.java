import java.io.*;
import java.util.*;

public class Main{
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            // 배추밭 입력받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] field = new int[N][M]; // 초기값 : 0
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }
            
            // 필요한 배추흰지렁이 수 세기
            int count = 0;
            for(int k=0; k<N; k++){
                for(int j=0; j<M; j++){
                    if(field[k][j] == 1){
                        queue.add(new int[] {k, j});
                        bfs(k, j, queue, M, N, field);
                        count++; // 지렁이 갯수 +1
                    }
                }
            }
            System.out.println(count);
            
        }
        
    }
    static void bfs(int x, int y, Queue<int[]> queue, int M, int N, int[][] field){
        while(queue.size() != 0){
            int[] pair = queue.remove();
            x = pair[0];
            y = pair[1];
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if((0<=nx && nx<N) && (0<=ny && ny<M)){
                    if(field[nx][ny]==1){
                        queue.add(new int[] {nx, ny});
                        field[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
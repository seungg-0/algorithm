import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<int []> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][M];
        
        char[] charArray;
        for(int i=0; i<N; i++){
            charArray = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(charArray[j]+"");
            }
        }
        
        queue.add(new int[] {0, 0});
        
        int[] xy;
        int nx, ny, x, y;
        while(!queue.isEmpty()){
            xy = queue.remove();
            x = xy[0];
            y = xy[1];
            for(int i=0; i<4; i++){
                nx = x+dx[i];
                ny = y+dy[i];
                if((nx>=0)&&(nx<N)&&(ny>=0)&&(ny<M)&&graph[nx][ny]==1){
                    graph[nx][ny] = graph[x][y]+1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        System.out.println(graph[N-1][M-1]);
    }
}
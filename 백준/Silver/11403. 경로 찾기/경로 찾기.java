import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int k=0; k<N; k++){ // 경유
            for(int i=0; i<N; i++){ // 시작
                for(int j=0; j<N; j++){ // 도착
                    if((graph[i][j] == 1) || ((graph[i][k]==1)&&(graph[k][j]==1))){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
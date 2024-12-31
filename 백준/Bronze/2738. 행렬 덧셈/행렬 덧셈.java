import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] graph = new int[r][c];
        
        for(int n=0; n<2; n++){
            for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<c; j++){
                graph[i][j] += Integer.parseInt(st.nextToken());
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
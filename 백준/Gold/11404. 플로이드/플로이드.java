// 최소 비용 업데이트 
// 이중배열, 초기 비용 저장
// 플로이드 와샬 알고리즘 사용해서 최소비용 업데이트 

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        long[][] graph = new long[N+1][N+1];
        
        int s, e, c;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(graph[s][e]>(long)0){ // 초기 비용 저장
                graph[s][e] = Math.min(graph[s][e], (long)c);
            } else{
                graph[s][e] = (long)c;
            }
        }
        
        // 플로이드 와샬 알고리즘 사용해서 최소비용 업데이트 
        for(int m=1; m<=N; m++){ // 경유
            for(int sc=1; sc<=N; sc++){ // 시작도시
                for(int ec=1; ec<=N; ec++){ // 도착도시
                    if(graph[sc][m] != 0 && graph[m][ec]!= 0){
                        if(graph[sc][ec] == 0){
                            graph[sc][ec] = graph[sc][m] + graph[m][ec];
                        } else if((graph[sc][m] + graph[m][ec]) < graph[sc][ec]){
                            graph[sc][ec] = graph[sc][m] + graph[m][ec];
                        }
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){
                    sb.append(0).append(" ");
                } else{
                    sb.append(graph[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
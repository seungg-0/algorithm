// 양방향 연결 
// DFS

import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] linkedInfo;
    static int answer, N;
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        linkedInfo = new ArrayList[N];
        for(int i=0; i<N; i++){
            linkedInfo[i] = new ArrayList<>();
        }
        
        int a, b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            linkedInfo[a].add(b);
            linkedInfo[b].add(a);
        }
        
        visited = new boolean[N];
        answer = 0;
        for(int i=0; i<N; i++){
            visited[i] = true;
            DFS(i, 1); 
            visited[i] = false;
        }
        System.out.println(answer);
    }
    static void DFS(int n, int depth){
        if(depth == 5){
            answer = 1;
            System.out.println(answer);
            System.exit(0);
        }
        
        for(int i : linkedInfo[n]){
            if(!visited[i]){
                visited[i] = true;
                DFS(i, depth+1);
                visited[i] = false;
            }
        }
    }
}
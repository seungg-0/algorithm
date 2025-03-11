// BFS 

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        ArrayList<Integer>[] graph;
        Queue<Integer> queue = new LinkedList<>();
        
        int C = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[C+1];
        for(int i=0; i<=C; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int answer = 0;
        queue.add(1);
        boolean[] visited = new boolean[C+1];
        while(!queue.isEmpty()){
            int q = queue.remove();
            visited[q] = true;
            answer++;
            
            for(int num : graph[q]){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
        
        System.out.println(answer-1);
        
    }
}
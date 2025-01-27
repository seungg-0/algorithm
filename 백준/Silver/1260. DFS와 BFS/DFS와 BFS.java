import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] linkedInfo;
    static boolean[] Bvisited;
    static boolean[] Dvisited;
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        // 연결정보 저장
        linkedInfo = new ArrayList[N+1];
        for(int i=0; i<linkedInfo.length; i++){ 
            linkedInfo[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            linkedInfo[s].add(e);
            linkedInfo[e].add(s);
        }
        
        // 각 노드에 대해 연결된 노드들을 오름차순으로 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(linkedInfo[i]);
        }
        
        // DFS
        Dvisited = new boolean[N+1];
        DFS(V);
        
        sb.append("\n");
        
        // BFS
        Bvisited = new boolean[N+1];
        BFS(V);
        
        System.out.println(sb);
    }
    
    static void BFS(int i){
        queue = new LinkedList<>();
        Bvisited[i] = true;
        sb.append(i).append(" ");
        queue.add(i);
        while(queue.size() != 0){
            int n = queue.remove();
            for(int num : linkedInfo[n]){
                if(!Bvisited[num]){
                    Bvisited[num] = true;
                    sb.append(num).append(" ");
                    queue.add(num);
                }
            }
        }
    }
    
    static void DFS(int i){
        Dvisited[i] = true;
        sb.append(i).append(" ");
        for(int num : linkedInfo[i]){
            if(!Dvisited[num]){
                DFS(num);
            }
        }
    }
}
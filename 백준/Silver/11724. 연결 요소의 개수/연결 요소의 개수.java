import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> linkedInfo = new ArrayList<>();
    
    static void bfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> linkedInfo, Queue<Integer> queue){
        while(queue.size() != 0){
            int n = queue.remove();
            for(int num : linkedInfo.get(n)){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<=N; i++){
            linkedInfo.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){ // 연결정보 저장
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            linkedInfo.get(s).add(e); 
            linkedInfo.get(e).add(s);
        }
        
        // 연결 요소 수 구하기
        visited = new boolean[N+1];
        Queue<Integer> queue;
        int num = 0;
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                queue = new LinkedList<>();
                visited[i] = true;
                queue.add(i);
                bfs(i, visited, linkedInfo, queue);
                num++;
            }
        }
        System.out.println(num);   
    }
}
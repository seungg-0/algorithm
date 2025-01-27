// DFS
import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static boolean[] visited;
    static ArrayList<Integer>[] linkedInfo;
    static int[] answer;
    public static void main(String[] arge)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N+1];
        answer = new int[N+1];
        linkedInfo = new ArrayList[N+1];
        for(int i=0; i<linkedInfo.length; i++){
            linkedInfo[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N-1; i++){ // 연결정보 저장
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            linkedInfo[s].add(e);
            linkedInfo[e].add(s);
        }
        
        visited[1] = true;
        DFS(1);
        for(int i=2; i<=N; i++){
            System.out.println(answer[i]);
        }
    }
    
    static void DFS(int i){
        for(int num : linkedInfo[i]){
            if(!visited[num]){
                visited[num] = true;
                answer[num] = i; // 부모 정보 저장
                DFS(num);
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] linkedInfo; // [복습]
    static Queue<Integer> queue;
    static int[] distances;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        linkedInfo = new ArrayList[N+1]; // [복습]
        for(int i=0; i<=N; i++){
            linkedInfo[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){ // 연결 정보 저장
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            linkedInfo[A].add(B);
        }
        
        distances = new int[N+1]; // X도시로부터 모든 도시까지의 거리 정보 저장
        Arrays.fill(distances, -1); // [암기] distances 초기값을 -1로 설정
        // BFS (최단거리 -> BFS 이용)
        queue = new LinkedList<>();
        distances[X] = 0;
        queue.offer(X);
        while(!queue.isEmpty()){
            int nowCity = queue.poll();
            for(int nextCity : linkedInfo[nowCity]){
                if(distances[nextCity]==-1){
                    distances[nextCity] = distances[nowCity]+1;
                    queue.offer(nextCity);
                }
            }
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(distances[i] == K){
                answer.add(i);
            }
        }
        
        Collections.sort(answer);
        if(answer.isEmpty()){
            System.out.println("-1");
        } else{
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<answer.size(); j++){
                sb.append(answer.get(j)).append("\n");
            }
            System.out.println(sb);
        }
    }
}
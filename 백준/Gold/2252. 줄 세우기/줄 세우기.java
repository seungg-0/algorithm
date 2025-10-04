// 순서가 있는 작업들을 차례대로 나열 (사이클 없는 방향 그래프) -> 위상 정렬 사용
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N명의 학생 줄세우기
        int M = Integer.parseInt(st.nextToken()); // M번의 키 비교
        
        List<List<Integer>> list = new ArrayList<>(); // 방향 정보 저장 [주의] 초기화 잊지 말기
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>()); // [암기]
        }
        int[] indegree = new int[N+1]; // 선행되어야 하는 사람 수 저장
        
        int a;
        int b;
        for(int i=0;i<M; i++){ // 키 비교 정보 입력받기 
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list.get(a).add(b); // a->b 방향 저장 
            indegree[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){ // 선행되어야 할게 없으면
                queue.offer(i); // 바로 줄 세울 수 있는 것들 
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int now;
        int next;
        while(!queue.isEmpty()){
            now = queue.poll();
            sb.append(now).append(" "); // 줄 세우기
            for(int i=0; i<list.get(now).size(); i++){
                next = list.get(now).get(i); // 다음 후행 건
                indegree[next]--; // 선행 하나 제거해주기 
                
                if(indegree[next]==0){ // 선행이 하나도 없어지면
                    queue.offer(next); // 바로 줄세울 수 있는 큐에 넣기
                }
            }
        }
        
        System.out.println(sb);
        
    }
}
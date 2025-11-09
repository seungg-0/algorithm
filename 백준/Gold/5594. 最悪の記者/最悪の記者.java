// 위상정렬 (사이클 없는 방향 그래프의 간선 방향을 거스르지 않도록 선형 순서로 나열하는 알고리즘)
// 선 하나 구하고, 갯수 세기
// 갯수 1이면 마지막 0 그 이상이면 마지막 1

import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] arge)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine()); // 팀 수
        int m = Integer.parseInt(br.readLine()); // 붙은 수
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        int w, l;
        boolean[] wlist = new boolean[n+1];
        boolean[] llist = new boolean[n+1];
        int[] outputs = new int[n+1];
        int[] inputs = new int[n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            wlist[w] = true;
            l = Integer.parseInt(st.nextToken());
            llist[l] = true;
            graph[w].add(l); // 진팀 연결하기
            outputs[w]++;
            inputs[l]++;
        }
        
        // 마지막이 0인지 1인지 판단 
        int countZero = 0;
        int last = 0;
        for(int i=1; i<=n; i++){
            if(outputs[i]==0){
                countZero++;
            }
        }
        if(countZero==1){
            last = 0;
        }else {
            last = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                if(inputs[i]==0){
                    queue.offer(i);
                }
                while(!queue.isEmpty()){
                    int now = queue.poll();
                    sb.append(now).append("\n");
                    for(int next : graph[now]){
                        if(!visited[next]){
                            inputs[next]--;
                            if(inputs[next]==0){
                                visited[next] = true;
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }
        sb.append(last);
        System.out.println(sb);
    }
}
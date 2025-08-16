// DFS

import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Integer>[] linked;
    static boolean[] route;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행계획에 포함된 도시 수

        linked = new ArrayList[N+1]; // 도시간 연결 정보 [문법 복습]
        for(int i=1; i<=N; i++){
            linked[i] = new ArrayList<>();
        }
        
        int num;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                num = Integer.parseInt(st.nextToken());
                if(num==1){
                    linked[i].add(j); // i도시는 j도시와 연결
                    linked[j].add(i); // j도시는 i도시와 연결
                } 
            }
        }
        
        st = new StringTokenizer(br.readLine(), " "); // 여행 계획에 포함된 도시 입력
        int[] cities = new int[M]; 
        for(int i=0; i<M; i++){
            cities[i] = Integer.parseInt(st.nextToken());
        }
        
        route = new boolean[N+1];
        DFS(cities[0]);

        boolean flag = true;
        for(int city : cities){
            if(!route[city]){
                flag = false;
                break;
            }
        }
        
        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static void DFS(int city){
       route[city] = true;
       for(int c : linked[city]){
           if(!route[c]){
                DFS(c);
           }
        }
    } 
}
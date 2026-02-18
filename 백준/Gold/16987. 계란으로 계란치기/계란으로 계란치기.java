// N 최대가 8 > 완탐 ! 
// 들고 한 번씩 다 쳐보기 (한 번씩만 침)
// 왼쪽부터 탐색하면서, 1. 본인이 깨진거면 continue 2. 안깨진 계란 치기 
// 끝까지 탐색하면 종료조건 (result값 업데이트)

import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] eggs;
    static int result;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        
        int s, w;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            eggs[i][0] = s;
            eggs[i][1] = w;
        }
        
        result = 0;
        DFS(0);
        System.out.println(result);
    }
    
    static void DFS(int egg){
        // 종료조건
        if(egg==N){
            result = Math.max(result, countAlive());
            return;
        }
        
        boolean hit = false;
        for(int i=0; i<N; i++){
            if(eggs[i][0]<=0 || egg == i){ // 깨진 계란이면 다음 계란 탐색
                continue;
            }
            
            if(eggs[egg][0]<0){
                DFS(egg+1); // 지금 들고 있는 계란이 깨진 계란이면
            }
            
            if(eggs[i][0]>0 && eggs[egg][0]>0){
                // 안깨진 계란 서로 공격 
                hit = true;
                eggs[egg][0] -= eggs[i][1];
                eggs[i][0] -= eggs[egg][1];
                DFS(egg+1);
                eggs[egg][0] += eggs[i][1];
                eggs[i][0] += eggs[egg][1];
            }

        }
        if(!hit){ // 남은 계란이 다 깨져있으면
            DFS(egg+1);
            hit = false;
        }
    }
    
    static int countAlive(){
        int cnt = 0;
        for(int i=0; i<N; i++){
            if(eggs[i][0]<=0){
                cnt++;
            }
        }
        return cnt;
    }
}

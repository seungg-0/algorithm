// 그리디 : 매순간 최선의 선택
// 끝나는 시간으로 오름차순 

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N][2]; // 입력되는 회의 일정들
        
        for(int i=0; i<N; i++){ // 주어진 회의실 일정 입력받기 
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            schedules[i] = new int[] {s,e}; // [형식암기]
        }
        
        // 정렬 (끝나는시간, 시작하는시간) 작은 순으로 오름차순 정렬 [암기]
        Arrays.sort(schedules, (a, b) ->{
            int diff = a[1]-b[1]; // 끝나는시간 순 오름차순
            if(diff==0){ // 끝나는 시간이 같다면
                return a[0]-a[1]; // 시작하는 시간 오름차순
            } else{
                return diff;
            }
        });
        
        int answer = 0;
        int startable = 0, s = 0, e = 0;
        // 그리디 
        for(int[] schedule : schedules){
            s = schedule[0];
            e = schedule[1];
            if(s>=startable){
                startable = e;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
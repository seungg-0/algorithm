// K개 연속해서 먹을 경우 할인된 정액 가격 
// 쿠폰의 초밥 1개 무료 제공 
// 먹을 수 있는 초밥 가짓수의 최댓값 구하기 

// 고정된 연속된 길이 -> 슬라이딩 윈도우
// 쿠폰이 해당 구간에 포함되는지 아닌지만 확인하면 됨
// 배열로

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 초밥 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        
        int[] table = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            table[i] = Integer.parseInt(br.readLine());
        }
        
        // 슬라이딩 윈도우
        int left = 0;
        int sum = 0;
        int answer;
        for(int i=0; i<k; i++){ // 앞 k개 먼저 확인
            if(map.containsKey(table[i])){
                map.put(table[i], map.get(table[i])+1);
            }else{
                map.put(table[i], 1);
            }
        }
        if(map.containsKey(c)){
            answer = map.size();
        }else{
            answer = map.size()+1;
        }

        for(int right=k; right<N+k; right++){ // 원형 회전초밥이라 회전 한 바퀴 끝까지 해줘야 함
            int r = table[right%N];
            if(map.containsKey(r)){
                map.put(r, map.get(r)+1);
            }else{
                map.put(r, 1);
            }
            
            if(map.get(table[left])==1){
                map.remove(table[left]);
            }else{
                map.put(table[left], map.get(table[left])-1); 
            }
            left = (left+1)%N;

            answer = Math.max(answer, map.containsKey(c) ? map.size() : map.size()+1);
        }
        System.out.println(answer);
    }
}






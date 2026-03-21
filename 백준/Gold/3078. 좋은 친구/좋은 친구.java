// 슬라읻이 윈도우, 큐 사용
// K길이만큼 슬라이딩윈도우 길이 유지하고
// 큐에 하나씩 넣고 (넣을 때마다 answer 갱신. 윈도우 내 현재 사람보다 앞에 있는 사람들이랑 다 친구 먹음)
// K길이 초과하면 맨 앞에 사람 빼고 count에서도 제거하기 
// count는 index : 이름 길이 value : 사람 수

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] count = new int[21]; // 이름 최대 21글자 
        long answer = 0; // [입력값 너무 많을 때는 자료형 주의]
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            int len = br.readLine().length(); // 이름 하나 입력받기
            
            answer+=count[len]; // 현재보다 앞에 있는 사람들 더하기
            count[len]++; // 현재 사람 추가 
            q.add(len);
            
            if(q.size()>K){
                int remove = q.poll();
                count[remove]--; // 슬라이딩 윈도우 (K개 초과하면 맨 앞 하나 빼기)
            }
        }
        System.out.println(answer);
    }
}
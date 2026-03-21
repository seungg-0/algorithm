// 부분 합이 K인 것이 몇 개나 있는지 구하기 
// 길이가 정해지지 않은 부분합(연속된 것들의 합) : 누적합
// [핵심 아이디어] prefix[i]-prefix[j] = K -> prefix[i]-K = prefix[j]
// 모든 누적합의 조합을 다 구하는게 아니라, 시간복잡도 N에 다 확인할 수 있는 식으로 변경하기
// N번으로 순회하면서, 누적값 계속 해시맵에 넣고, prefix[i]-K와 같은 것의 수를 합하면 됨
// 식을 변형 해주었기 때문에 N 한번만 순회하면 됨. 그럼 모든 케이스 고려하는 것.

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        // 위에 구문이 없으면 arr[0]=3, K=3 일 때, 카운트가 안됨
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        Long K = Long.parseLong(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        Long sum = 0L;
        Long answer = 0L;
        for(int i=0; i<N; i++){
            sum += Long.parseLong(st.nextToken()); // 앞에서부터 누적합 하나씩 순회
            
            // answer += 를 먼저 해줘야 i==j 인 상황이 발생하지 않는다. 
            answer += map.getOrDefault(sum-K, 0L); // 누적합 중 prefix[i]-K랑 같은 거 있으면 더해줘야 함
            map.put(sum, map.getOrDefault(sum, 0L)+1); // 누적합 해시맵에 넣기
        }
        System.out.println(answer);
    }
}


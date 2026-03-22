// 산성 : 양수 / 알칼리성 : 음수
// 합한 값이 0에 가까운 용액을 만들려고 함 
// 정렬된 순서로 주어짐 
/*
투 포인터 (정렬된 배열에서 많이 사용)
- 양끝값을 left, right로 지정하고
0. 합한 값 이전 합한 값과 비교하여 0과 더 작아지면 go 아니면 stop
1. 합한 값이 음수면 left += 1
2. 합한 값이 양수면 right -= 1
*/

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 투포인터
        int left=0;
        int right=N-1;
        int ansleft=0;
        int ansright=0;
        while(left<right){
            int sum = inputs[left]+inputs[right];
            
            // [주의] 투 포인터는 "중간에 멈추면 안됨"
            if(Math.abs(sum)<Math.abs(answer)){
                ansleft = left;
                ansright = right;
            }
            
            answer = Math.min(Math.abs(answer), Math.abs(sum));
            
            if(sum<0){    
                left++;
            } else if(sum>0){
                right--;
            } else{
                break; // 더 좋은 값 나올 수 없음
            }
        }
        System.out.println(inputs[ansleft]+" "+inputs[ansright]);
    }
}
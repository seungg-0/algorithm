// 에라토스테네스의 체로 소수인것들 표시해두기
// DFS로 백트래킹 하면서 신기한 소수 찾기 

import java.util.*;
import java.io.*;

public class Main{
    // static boolean[] isPrime;
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        int N = 100000000;
        // isPrime = new boolean[N];
        // Arrays.fill(isPrime, true);
        // isPrime[1] = false; // 1은 소수 아님
        
        /* 여기서 메모리 초과 발생. 즉석 소수 판별 함수 이용
        // 소수인지 아닌지 판단 (에라토스테네스의 체 [복습]!!!!!!!!)
        for(int i=2; i<=Math.sqrt(N); i++){
            if(!isPrime[i]) continue;
            for(int j=i+i; j<N; j+=i){
                isPrime[j] = false; // 소수의 배수는 소수 아님
            }
        }
        */
        
        int[] start = {2, 3, 5, 7};
        for(int num : start){
            DFS(num, 1);
        }
        System.out.println(sb);
        
    }
    
    static void DFS(int num, int len){
        if(len==n){
            sb.append(num).append("\n");
            return;
        }
        
        for(int i=1; i<10; i+=2){ // 짝수를 붙이면 무조건 소수가 아님 (회적화)
            int next = num*10 + i; // String 붙여서 int 형변환 계속하는것보다 int형으로만 표현하는게 효율적
            if(isPrime(next)){
                DFS(next, len+1);
            }
        }
    }
    
    static boolean isPrime(int x){ // 에라토스 테네스 x 걍 소수판별 함수 (2부터 제곱근까지 수 중에서 나눠떨어지는 수 있는지 확인)
        if(x<2) return false;
        for(int i=2; i<=Math.sqrt(x); i++){ // 제곱근까지 보면 됨 !!! [암기]
            if(x % i == 0) return false;
        }
        return true;
    }
}

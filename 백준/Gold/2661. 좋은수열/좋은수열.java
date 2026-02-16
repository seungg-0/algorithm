// 백트래킹
// 백트래킹 하면서 종료조건일 때, 나쁜 수 아닌거 찾기 
// N-Queen 풀 때도 틀렸던 부분을 또 틀림.
// 백트래킹의 핵심은, 종료조건에서 가능한지안한지 판단하는게 아니라 (퀸을 놓을 수 있는지, 착한 수인지)
// 수를 하나씩 추가할 때마다 착한 수인지 바로 판단하고, 그렇지 않으면 안붙여야 함. 

import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        DFS("");
    }
    
    static void DFS(String ans){
        
        // 종료조건 : 길이가 N이 되었을 때
        if(ans.length()==N){
            System.out.println(ans);
            System.exit(0);
        }
        
        for(int i=1; i<=3; i++){ // 수열 숫자 1, 2, 3으로만 이루어져 있음
            String next = ans + i;
            if(isKind(next)){
                DFS(next);
            }
        }
    }
    
    static boolean isKind(String word){
        int len = word.length();
        
        for(int i=1; i<=len/2; i++){
            String a = word.substring(len-i*2, len-i); // 그 앞 i개
            String b = word.substring(len-i); // 맨 뒤 i개
            if(a.equals(b)) return false;
        }
        return true;
    }
}

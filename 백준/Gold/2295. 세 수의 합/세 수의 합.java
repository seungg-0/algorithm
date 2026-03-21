// 핵심 아이디어 : a + b + c = d -> a + b = d - c

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(arr);
        
        HashSet<Integer> set = new HashSet<>();
        
        // 두 수의 합 저장
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                set.add(arr[i]+arr[j]);
            }
        }
        
        for(int i=N-1; i>=0; i--){
            for(int j=0; j<=i; j++){
                if(set.contains(arr[i]-arr[j])){
                    System.out.println(arr[i]);
                    return;
                }
            }
        } 
    }
}
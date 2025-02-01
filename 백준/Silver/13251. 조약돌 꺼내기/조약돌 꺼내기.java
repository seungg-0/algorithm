import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int M = Integer.parseInt(br.readLine());
        int[] colors = new int[M];
        int total = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            colors[i] = Integer.parseInt(st.nextToken());
            total += colors[i];
        }
        int K = Integer.parseInt(br.readLine());
        
        double totalCombinations = 1;
        // 전체 경우의 수 구하기
        for(int i=0; i<K; i++){
            totalCombinations *= (double)(total-i);
        }
        
        double possibilities = 0;
        // 각 색상의 경우의 수 구하기
        for(int i=0; i<M; i++){
            if(colors[i]>=K){
                possibilities += combi(colors[i], K);
            }
        }
        
        System.out.println((possibilities/totalCombinations));
    }
    
    static double combi(int c, int k){
        double cnt = 1;
        for(int i=0; i<k; i++){
            cnt *= (double)(c-i); // [암기]
        }
        return cnt;
    }
}
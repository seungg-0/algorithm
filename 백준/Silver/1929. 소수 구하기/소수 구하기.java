import java.util.*;
import java.io.*;

public class Main{
    
    static boolean isPrime(int n){
        if(n==1){
            return false;
        } else{
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=M; i<=N; i++){
            if(isPrime(i)){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
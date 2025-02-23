import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long result;
        if(a%b==0){
            result = b;
        } else{// 유클리드 호제법 
            result = GCD(a, b);
        }
        
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<result; i++){
            ans.append("1");
        }
        System.out.println(ans);
    }
    
    static long GCD(long num1, long num2){
        if(num1%num2==0){
            return num2;
        } else{
            return GCD(num2, num1%num2);
        }
    }
}
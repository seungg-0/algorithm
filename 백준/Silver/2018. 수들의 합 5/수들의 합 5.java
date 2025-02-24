import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int accumulate = 0, cnt = 0;
        for(int i=1; i<=N; i++){
            accumulate = i;
            if(accumulate==N){
                cnt++;
            }
            for(int j=i+1; j<=N; j++){
                accumulate += j;
                if(accumulate>N){
                    break;
                } else if(accumulate==N){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
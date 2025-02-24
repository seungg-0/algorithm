import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] windows = new int[N];
        
        for(int i=0; i<N; i++){
            windows[i] = i+1;
        }
        
        int left = 0, right = 0, cnt = 0;
        int total = windows[0];
        while(right<N){
            if(total==N){
                cnt++;
                right++;
                if(right>=N){
                    break;
                }
                total += windows[right];
            } else if(total<N){
                right++;
                if(right>=N){
                    break;
                }
                total += windows[right];
            } else{
                total -= windows[left];
                left++;
            }
        }
        System.out.println(cnt);
    }
}
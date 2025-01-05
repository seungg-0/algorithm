import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        int diff = M;
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int h=j+1; h<N; h++){
                    int total = cards[i]+cards[j]+cards[h];
                    if(M>=total){
                        if(diff>M-total){
                            diff = (M-total);
                            result = total;
                        } 
                    }
                }
            }
        }
        System.out.println(result);
    }
}
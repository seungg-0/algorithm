import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        long N = Long.parseLong(br.readLine());
        long M = Long.parseLong(br.readLine());
        
        int size = (int) N;
        long[] materials = new long[size]; // [암기] 배열을 지정하는 값은 반드시 int타입이어야 한다 !
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<size; i++){
            materials[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(materials); // [복습] 오름차순 정렬
        
        if(N==1){
            System.out.println(0);
        } else{
            long cnt = 0;
            int s = 0;
            int e = size-1;
            while(s<e){
                if((materials[s]+materials[e])==M){
                    cnt++;
                    s++;
                    e--;
                } else if((materials[s]+materials[e])<M){
                    s++;
                } else{
                    e--;
                }
            }
            System.out.println(cnt);  
        }  
    }
}

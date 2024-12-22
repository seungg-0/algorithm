import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            int result = 0;
            if(num == 1) continue;
            if(num == 2) {
                count ++; // 2는 소수
                continue;
            }
            for(int j=2; j<num; j++){
                if(num%j==0) result = 1; // 2이상이 값 중에 나누어떨어지는 수 있으면 소수가 아니다.
            }
            if(result==0) count++; 
        }
        System.out.print(count);
    }
}
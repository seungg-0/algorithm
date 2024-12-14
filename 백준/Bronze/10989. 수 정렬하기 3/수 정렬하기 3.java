import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수의 범위 (0 ~ 10000) 
        int[] cnt = new int[10001];
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            // 입력 숫자 인덱스의 값을 1 증가
            cnt[Integer.parseInt(br.readLine())]++;
        }
        
        br.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<10001; i++){
            while(cnt[i]>0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
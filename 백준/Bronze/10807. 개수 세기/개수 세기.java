import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        // 버퍼드 리더를 통해 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받은 첫 번째 값을 N에 저장
        int N = Integer.parseInt(br.readLine());
        
        // 입력받은 정수 크기의 배열 선언
        int[] arr = new int[N];
        
        // 입력받은 값을 공백을 기준으로 분리 
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
  
        for(int i=0; i<N; i++){
            //스트림 토크나이저로 분리한 입력값들을 배열에 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 찾을 값인 V, 입력받아 저장
        int V = Integer.parseInt(br.readLine());
        int count = 0; // V와 일치할 시 값이 오를 count
        
        for(int i = 0; i<N; i++){
            if(arr[i]==V){
                count++;
            }
        }
        System.out.println(count);
        br.close();
    }
}
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력 받기
        int N = Integer.parseInt(br.readLine());
        
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        
        int tmp = 0;
        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i=0; i<N; i++){ // 순회 한 번만 해야함
            
            while(!stack.empty()&&input[stack.peek()]<input[i]){ // 오큰수 찾았으면
                tmp = stack.pop(); // 오큰수 찾았으면 stack 에서 빼기 (오큰수 찾는 대상 수의 인덱스)
                result[tmp] = input[i]; // 오큰수 입력
            }
            stack.push(i); // 오큰수 찾는 대상 수의 인덱스 넣기
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(result[i]).append(" ");
        }
        
        System.out.println(sb);
    }
}
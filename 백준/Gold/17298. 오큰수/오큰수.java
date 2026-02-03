import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            ans[i] = -1; // 기본값: 오큰수 없음
        }

        // 인덱스를 저장하는 스택
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            // 현재 값 A[i]가
            // 스택 top에 있는 과거 값보다 크면
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                // 디버깅
                // System.out.println("peek: "+Integer.toString(stack.peek())+"A[i]"+Integer.toString(A[i]));
                int idx = stack.pop();   // 오큰수 찾은 인덱스
                ans[idx] = A[i];         // 현재 값이 오큰수
            }

            // 아직 오큰수를 못 찾은 현재 인덱스
            stack.push(i);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb);
    }
}

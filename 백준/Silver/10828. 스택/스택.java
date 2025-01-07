import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령 갯수 입력받기
        
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            } else if(command.equals("pop")){
                if(stack.size()==0) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            } else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            } else if(command.equals("empty")){
                if(stack.size()==0) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else{
                if(stack.size()==0) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
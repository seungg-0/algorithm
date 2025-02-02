// 괄호 적절히 쳐서 식의 값을 최소로 만들기 
// 스택, -가 나올 때까지 꺼내서 계속 더하기. - 나오면 그동안 누적한 값 빼기

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-+", true); // [암기] '-'와 '+'을 기준으로 분리, true를 써줌으로써 '-'와 '+'도 포함시켜서 저장함
        Stack<String> stack = new Stack<>(); // [암기]
        
        while (st.hasMoreTokens()){ // [암기]
            stack.push(st.nextToken());
        }
        
        int sum = 0;
        int result = 0;
        while(!stack.isEmpty()){
            String token = stack.pop();
            if(!token.equals("+")&&!token.equals("-")){
                sum += Integer.parseInt(token);
            } else if(token.equals("+")){
                continue;
            } else if(token.equals("-")){
                result -= sum;
                sum = 0;
            }   
        }
        if(sum>0) result += sum;  
        System.out.println(result);
    }
}


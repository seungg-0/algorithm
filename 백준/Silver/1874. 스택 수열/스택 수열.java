import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        
        // a : 만들어야하는 | b : 집어넣는
        // 0. a=b + - 
        // 1. a<b NO 
        // 2. a>b 같아질 때까지 집어넣기 
        
        int current = 1;
        StringBuilder sb = new StringBuilder();
        int aidx = 0;
        while(current <= n || !stack.isEmpty()){
            if(array[aidx]==current){
                sb.append("+\n-\n");
                aidx++;
                current++;
            } else if(array[aidx]>current){
                stack.push(current);
                current++;
                sb.append("+\n");
            } else if (!stack.isEmpty()&&stack.peek()==array[aidx]){ 
                stack.pop();
                sb.append("-\n");
                aidx++;
            } else { // array[aidx]<current
                break;
            } 
        }
        if(aidx < n-1){
            System.out.println("NO");
        } else{
            System.out.println(sb);
        }
    }
}
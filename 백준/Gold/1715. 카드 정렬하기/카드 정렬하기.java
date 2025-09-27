import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> minHeap = new PriorityQueue<>(); // 최소힙
    
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            minHeap.add(Long.parseLong(br.readLine())); // 최소힙에 값 추가
        }
        
        long num1;
        long num2;
        long answer = 0L;
        while(minHeap.size()>=2){
            num1 = minHeap.poll();
            num2 = minHeap.poll();
            answer += (num1+num2);
            minHeap.add(num1+num2);
        }
        
        System.out.println(answer);
    }
}
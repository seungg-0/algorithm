import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // [암기] 최소힙
        
        int N = Integer.parseInt(br.readLine());
        
        int x;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());
            if(x==0 && minHeap.isEmpty()){ // 0 입력되고, 배열 비어있을 때
                sb.append("0\n");
            } else if(x>0){ // 자연수 입력
                minHeap.offer(x);
            } else{ // 0 입력, 배열 비어있지 않을 때
                sb.append(minHeap.poll()).append("\n");
            }
        }
        
        System.out.println(sb);
       
    }
}
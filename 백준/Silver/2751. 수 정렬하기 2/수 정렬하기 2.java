import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            minHeap.add(Integer.parseInt(br.readLine()));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(minHeap.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> nmap = new HashMap<>(); // [암기]
        HashMap<String, Integer> mmap = new HashMap<>();
        
        for(int i=0; i<N; i++){
            nmap.put(br.readLine(), 1); // [암기]
        }
        for(int i=0; i<M; i++){
            mmap.put(br.readLine(), 1);
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(String name : nmap.keySet()){ // [암기]
            if(mmap.containsKey(name)){ // [암기]
                result.add(name);
            }
        }
        
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(int i=0; i<result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] poketmonBooks = new String[M+1];
        HashMap<String, Integer> poketmonBooksMap = new HashMap<>(); // [암기] 이렇게 자료형을 두가지 쓰면 된다 ! 
        
        for(int i=1; i<=M; i++){
            String input = br.readLine();
            poketmonBooks[i] = input;
            poketmonBooksMap.put(input, i); // [암기]
        }
        
        StringBuilder sb = new StringBuilder();
        String input;
        for(int i=0; i<N; i++){
            input = br.readLine();
            if(poketmonBooksMap.containsKey(input)){ // [암기]
                sb.append(poketmonBooksMap.get(input)).append("\n");
            } else{
                sb.append(poketmonBooks[Integer.parseInt(input)]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
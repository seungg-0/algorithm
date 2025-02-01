import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        ArrayList<String> Nlist = new ArrayList<>();
        ArrayList<String> Mlist = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            Nlist.add(br.readLine());
        }
        String input;
        int cnt = 0;
        for(int i=0; i<M; i++){
            input = br.readLine();
            Mlist.add(input);
            if(Nlist.contains(input)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
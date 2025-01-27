import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> S = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        String command = "";
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            if(command.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                if(!S.contains(Integer.valueOf(num))){
                    S.add(Integer.valueOf(num));  
                }
            } else if(command.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                if(S.contains(Integer.valueOf(num))){
                    S.remove(Integer.valueOf(num));  
                }
            } else if(command.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(S.contains(num)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(command.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(S.contains(num)) S.remove(Integer.valueOf(num));
                else S.add(num);
            } else if(command.equals("all")){
                S.clear();
                for(int j=1; j<=20; j++){
                    S.add(j); // {1, 2, ..., 20} 으로 바꾼다.
                }
            } else{
                S.clear(); // S를 공집합으로 바꾼다.
            }
        }
        System.out.println(sb);
    }
}
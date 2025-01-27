import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        
        //[암기] 다중배열 : Comparator 활용
        // 1. 길이가 짧은 것 부터
        // 2. 길이가 같으면 사전 순으로 
        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length())
                    return s1.compareTo(s2); // 길이 같으면 사전 순 정렬
                else
                    return s1.length() - s2.length();
            }
        });
        
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append('\n');
        
        // 중복 단어는 하나만 남기고 제거
        for(int i=1; i<n; i++){
            if(!arr[i].equals(arr[i-1]))
                sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}